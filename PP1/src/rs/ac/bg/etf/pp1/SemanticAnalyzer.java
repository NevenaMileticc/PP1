package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;


public class SemanticAnalyzer extends VisitorAdaptor {
	private boolean errorDetected = false;
	private Struct boolType;
	private Struct typeSet;
	Logger log = Logger.getLogger(getClass());

	private static int brojPromenljivihPrograma = 0;
	private boolean mainMetodaPronadjena = false;
	
	private Struct trenutniTip = null;
	private boolean daLiJePromenljivaNiz = false;
	private Obj trenutnaMetoda = null;
	private boolean returnPronadjen = false;
	private int brojFormalnihParametaraMetode = 0;
	
	private int dubinaDoWhilePetlje = 0;
	
	private Stack<List<Struct>> stekStvarnihParametara;

	
	enum RelacioniOperator {JEDNAKO, RAZLICITO, MANJE, VECE, VECE_JEDNAKO, MANJE_JEDNAKO}
	private RelacioniOperator relacioniOperator = null;
	
	public SemanticAnalyzer() {
		Struct boolType = new Struct(Struct.Bool);
		Obj boolObj = Tab.insert(Obj.Type, "bool", boolType);
		boolObj.setAdr(-1);
		boolObj.setLevel(-1);
		
		Struct typeSet = new TypeSet(TypeSet.Set);
		Obj objSet = Tab.insert(Obj.Type, "set", typeSet);
		objSet.setAdr(-1);
		objSet.setLevel(-1);
		
		// Definisanje funkcija add(set a, int b) i addAll(set a, int[] b)
		Obj methObj;
		Tab.currentScope.addToLocals(methObj = new Obj(Obj.Meth, "add", Tab.noType, 0, 2));
		{
			Tab.openScope();
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "a", typeSet, 0, 1));
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "b", Tab.intType, 0, 1));
			methObj.setLocals(Tab.currentScope.getLocals());
			Tab.closeScope();
		}
		
		Tab.currentScope.addToLocals(methObj = new Obj(Obj.Meth, "addAll", Tab.noType, 0, 2));
		{
			Tab.openScope();
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "a", typeSet, 0, 1));
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "b", new Struct(Struct.Array, Tab.intType), 0, 1));
			methObj.setLocals(Tab.currentScope.getLocals());
			Tab.closeScope();
		}
		
		// Predefinisane metode ord, chr, len, add i addAll nisu za formalne parametre imale postavljene FpPos na 1, pa smo to ovde uradili
		Obj ord = Tab.find("ord");
		for(Obj sim: ord.getLocalSymbols()) {
			sim.setFpPos(1);
		}
		
		Obj chr = Tab.find("chr");
		for(Obj sim: chr.getLocalSymbols()) {
			sim.setFpPos(1);
		}
		
		Obj len = Tab.find("len");
		for(Obj sim: len.getLocalSymbols()) {
			sim.setFpPos(1);
		}
		
		Obj add = Tab.find("add");
		for(Obj sim: add.getLocalSymbols()) {
			sim.setFpPos(1);
		}
		
		Obj addAll = Tab.find("addAll");
		for(Obj sim: addAll.getLocalSymbols()) {
			sim.setFpPos(1);
		}
		
		this.typeSet = Tab.find("set").getType();
		this.boolType = Tab.find("bool").getType();
		this.stekStvarnihParametara = new Stack<List<Struct>>();
		
	}
	
	
	/* LOG MESSAGES */
	public void report_error(String message, SyntaxNode info) {
		errorDetected  = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" ::Greska na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" ::na liniji ").append(line);
		log.info(msg.toString());
	}
	
	
	public static int getBrojPromenljivihPrograma() {
		return brojPromenljivihPrograma;
	}
	
	public static void setBrojPromenljivihPrograma(int broj) {
		brojPromenljivihPrograma = broj;
	}
	
	/* Pocetak i kraj programa*/
	@Override
	public void visit(ProgIme progIme) {
		// Napravimo novi objektni cvor koji za Type ima noType jer je tako po specifikaciji jezika
		progIme.obj = Tab.insert(Obj.Prog, progIme.getI1(), Tab.noType);
		// Otvorimo opseg
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {
		
		brojPromenljivihPrograma = Tab.currentScope().getnVars();
		
		if(mainMetodaPronadjena == false) {
			report_error("Nije pronadjena main metoda. ", null);
		}
		
		Tab.chainLocalSymbols(program.getProgIme().obj);
		Tab.closeScope();
		this.mainMetodaPronadjena = false;
	}
	
	/* Posecivanje Type*/
	
	@Override
	public void visit(Type type) {
		
		Obj typeCvor = Tab.find(type.getI1());
		
		if(typeCvor == Tab.noObj) {
			report_error("Tip " + type.getI1() + " nije pronadjen u tabeli simbola", type);
			type.struct = Tab.noType; // Da bi ispropagiralo dalje
		}
		else {
			if(typeCvor.getKind() == Obj.Type) {
				type.struct = typeCvor.getType();
			}
			else {
				report_error("Ime " + type.getI1() + " ne predstavlja tip", type);
				type.struct = Tab.noType; // Da bi ispropagiralo dalje
			}
		}
		
		this.trenutniTip = type.struct;
	}
	
	/* Posecivanje konstanti*/
	
	// Neke funkcije za proveru konstanti
	
	private boolean proveriImeKonstante(String imeKonstante, SyntaxNode info) {
		
		Obj cvorKonstante = Tab.find(imeKonstante);
		if(cvorKonstante != Tab.noObj) {
			// Konstanta je vec definisana, javi gresku
			report_error("Konstanta imena: " + imeKonstante + " je vec definisana ", info);
			return false;
		}
		// Konstanta nije definisana 
		return true;
	}
	
	private boolean proveriTipKonstante(String imeKonstante, Struct tipKonstante, SyntaxNode info) {
		
		if(!tipKonstante.equals(this.trenutniTip)) {
			report_error("Deklarisani tip konstante imena " + imeKonstante + " ne odgovara njenom dodeljenom tipu ", info);
			return false;
		}
		
		return true;
	}
	
	@Override
	public void visit(VrednostKonstante_bool vrednostKonstante_bool) {
		if(!this.proveriImeKonstante(vrednostKonstante_bool.getI1(), vrednostKonstante_bool)) {
			return;
		}
		if(!this.proveriTipKonstante(vrednostKonstante_bool.getI1(), this.boolType, vrednostKonstante_bool)) {
			return;
		}
		
		int vrednostKonstante = (vrednostKonstante_bool.getB2() == true) ? 1 : 0; 
		
		Obj cvorKonstanta = Tab.insert(Obj.Con, vrednostKonstante_bool.getI1(), this.boolType);
		report_info("Kreirana je konstanta imena " + vrednostKonstante_bool.getI1() + " i tipa bool", vrednostKonstante_bool);
		cvorKonstanta.setAdr(vrednostKonstante);
	}
	
	@Override
	public void visit(VrednostKonstante_int vrednostKonstante_int) {
		if(!this.proveriImeKonstante(vrednostKonstante_int.getI1(), vrednostKonstante_int)) {
			return;
		}
		if(!this.proveriTipKonstante(vrednostKonstante_int.getI1(), Tab.intType, vrednostKonstante_int)) {
			return;
		}
		
		int vrednostKonstante = vrednostKonstante_int.getN2(); 
		
		Obj cvorKonstanta = Tab.insert(Obj.Con, vrednostKonstante_int.getI1(), Tab.intType);
		report_info("Kreirana je konstanta imena " + vrednostKonstante_int.getI1() + " i tipa int", vrednostKonstante_int);
		cvorKonstanta.setAdr(vrednostKonstante);
	}
	
	@Override
	public void visit(VrednostKonstante_char vrednostKonstante_char) {
		if(!this.proveriImeKonstante(vrednostKonstante_char.getI1(), vrednostKonstante_char)) {
			return;
		}
		if(!this.proveriTipKonstante(vrednostKonstante_char.getI1(), Tab.charType, vrednostKonstante_char)) {
			return;
		}
		
		int vrednostKonstante = vrednostKonstante_char.getC2(); 
		
		Obj cvorKonstanta = Tab.insert(Obj.Con, vrednostKonstante_char.getI1(), Tab.charType);
		report_info("Kreirana je konstanta imena " + vrednostKonstante_char.getI1() + " i tipa char", vrednostKonstante_char);
		cvorKonstanta.setAdr(vrednostKonstante);
	}
	
	/* Posecivanje varijabli*/
	
	// Neke funkcije za proveru konstanti
	
	private boolean proveriImeVarijable(String imeVarijable, SyntaxNode info) {
		
		Obj cvorVarijable = Tab.find(imeVarijable);
		if(cvorVarijable != Tab.noObj && Tab.currentScope.findSymbol(imeVarijable) != null) {
			// Varijabla je vec deklarisana u ovom scopu, javi gresku
			report_error("Varijabla imena: " + imeVarijable + " je vec deklarisana ", info);
			return false;
		}
		// Konstanta nije definisana 
		return true;
	}
		
	@Override
	public void visit(VarijablaJeNiz varijablaJeNiz) {
		this.daLiJePromenljivaNiz = true;
	}
	
	@Override
	public void visit(PoslednjaVarijabla_ok poslednjaVarijabla_ok) {
		if(!this.proveriImeVarijable(poslednjaVarijabla_ok.getI1(), poslednjaVarijabla_ok)) {
			return;
		}
		// Umecemo varijablu u tabelu simbola
		Struct tipVarijable = this.trenutniTip;
		if(this.daLiJePromenljivaNiz == true) {
			tipVarijable = new Struct(Struct.Array, this.trenutniTip);
		}
		
		Tab.insert(Obj.Var, poslednjaVarijabla_ok.getI1(), tipVarijable);
		report_info("Kreirana je varijabla imena " + poslednjaVarijabla_ok.getI1(), poslednjaVarijabla_ok);
		
		this.daLiJePromenljivaNiz = false;
	}
	
	@Override
	public void visit(Varijabla_ok varijabla_ok) {
		if(!this.proveriImeVarijable(varijabla_ok.getI1(), varijabla_ok)) {
			return;
		}
		// Umecemo varijablu u tabelu simbola
		Struct tipVarijable = this.trenutniTip;
		if(this.daLiJePromenljivaNiz == true) {
			tipVarijable = new Struct(Struct.Array, this.trenutniTip);
		}
		
		Tab.insert(Obj.Var, varijabla_ok.getI1(), tipVarijable);
		report_info("Kreirana je varijabla imena " + varijabla_ok.getI1(), varijabla_ok);
		
		this.daLiJePromenljivaNiz = false;
	}
	
	/* Posecivanje skupova */
	
	// Neke funkcije za proveru skupova
	
	private boolean proveriImeSkupa(String imeSkupa, SyntaxNode info) {
		
		Obj cvorSkupa = Tab.find(imeSkupa);
		if(cvorSkupa != Tab.noObj && Tab.currentScope.findSymbol(imeSkupa) != null) {
			// Skup je vec deklarisan u ovom scopu, javi gresku
			report_error("Skup imena: " + imeSkupa + " je vec deklarisan ", info);
			return false;
		}
		// Skup nije deklarisan
		return true;
	}
	
	@Override
	public void visit(PoslednjiSkup_ok poslednjiSkup_ok) {
		if(!this.proveriImeSkupa(poslednjiSkup_ok.getI1(), poslednjiSkup_ok)) {
			return;
		}
		
	    Tab.insert(Obj.Var, poslednjiSkup_ok.getI1(), this.typeSet);
		report_info("Kreiran je skup imena " + poslednjiSkup_ok.getI1(), poslednjiSkup_ok);
		
	}
	
	@Override
	public void visit(Skup_ok skup_ok) {
		if(!this.proveriImeSkupa(skup_ok.getI1(), skup_ok)) {
			return;
		}
		
		Tab.insert(Obj.Var, skup_ok.getI1(), this.typeSet);
		report_info("Kreiran je skup imena " + skup_ok.getI1(), skup_ok);
	}
	
	
	/* Posecivanje metoda */
	
	private boolean proveriFormalneParametre(String imeFormalnogParametra, SyntaxNode info) {
		
		Obj cvorParametra = Tab.find(imeFormalnogParametra);
		
		if(cvorParametra != Tab.noObj && Tab.currentScope.findSymbol(imeFormalnogParametra) != null) {
			report_error("Ime formalnog parametra " + imeFormalnogParametra + " vec postoji u listi formalnih parametara ", info);
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public void visit(TipMetode_pravi tipMetode_pravi) {
		tipMetode_pravi.struct = this.trenutniTip;
	}
	
	@Override
	public void visit(TipMetode_void tipMetode_void) {
		tipMetode_void.struct = Tab.noType;
	}
	
	@Override
	public void visit(MethodSignature methodSignature) {
		Obj cvorMetode = Tab.find(methodSignature.getI2());
		if(cvorMetode != Tab.noObj) {
			report_error("Metoda sa imenom " + methodSignature.getI2() + " je vec definisana", methodSignature);
		}
		
		this.trenutnaMetoda = Tab.insert(Obj.Meth, methodSignature.getI2(), methodSignature.getTipMetode().struct);
		
		methodSignature.obj = this.trenutnaMetoda;
		
		Tab.openScope();
		
		report_info("Definicija metode sa imenom " + methodSignature.getI2(), methodSignature);
	}
	
	@Override
	public void visit(FormParamDecl_nijeSet formParamDecl) {
		this.brojFormalnihParametaraMetode++;
		
		if(!this.proveriFormalneParametre(formParamDecl.getI2(), formParamDecl)) {
			// Greska, visestruka definicija formalnog parametra
			return;
		}
		
		// Umecemo formalni parametar u tabelu simbola
		Struct tipParametra = this.trenutniTip;
		if(this.daLiJePromenljivaNiz == true) {
			tipParametra = new Struct(Struct.Array, this.trenutniTip);
		}
		
		Obj cvorParametra = Tab.insert(Obj.Var, formParamDecl.getI2(), tipParametra);
		cvorParametra.setFpPos(1);
		this.daLiJePromenljivaNiz = false;
	}
	
	@Override
	public void visit(FormParamDecl_Set formParamDecl) {
		this.brojFormalnihParametaraMetode++;
		
		if(!this.proveriFormalneParametre(formParamDecl.getI1(), formParamDecl)) {
			// Greska, visestruka definicija formalnog parametra
			return;
		}
		
		Obj cvorParametra = Tab.insert(Obj.Var, formParamDecl.getI1(), this.typeSet);
		cvorParametra.setFpPos(1);
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		 
		if(!this.returnPronadjen && this.trenutnaMetoda.getType() != Tab.noType) {
			report_error("Za metodu " + this.trenutnaMetoda.getName() + " ne postoji return iskaz. ", methodDecl);
			return;
		}
		
		
		this.trenutnaMetoda.setLevel(this.brojFormalnihParametaraMetode);
		
		if("main".equals(this.trenutnaMetoda.getName()) && this.trenutnaMetoda.getLevel() == 0) {
			this.mainMetodaPronadjena = true;
		}
		
		Tab.chainLocalSymbols(this.trenutnaMetoda);
		
		Tab.closeScope();
		
		// Resetujemo neke promenljive
		this.brojFormalnihParametaraMetode = 0;
		this.returnPronadjen = false;
		this.trenutnaMetoda = null;
	}
	
	
	/* Posecivanje faktora, Expresna, Termova*/
	
	@Override
	public void visit(Factor_int factor_int) {
		// Samo javimo glavnom Faktoru koji je tip, 
		// da bi on mogao da javi dalje kome treba
		factor_int.struct = Tab.intType;
	}
	
	@Override
	public void visit(Factor_char factor_char) {
		// Samo javimo glavnom Faktoru koji je tip, 
		// da bi on mogao da javi dalje kome treba
		factor_char.struct = Tab.charType;
	}
	
	@Override
	public void visit(Factor_bool factor_bool) {
		// Samo javimo glavnom Faktoru koji je tip, 
		// da bi on mogao da javi dalje kome treba
		factor_bool.struct = this.boolType;
	}
	
	@Override
	public void visit(Factor_expr factor_expr) {
		factor_expr.struct = factor_expr.getExpr().struct;
	}
	
	@Override
	public void visit(Factor_designator factor_designator) {
		factor_designator.struct = factor_designator.getDesignator().obj.getType();
		
		if(factor_designator.getDesignator().obj.getKind() == Obj.Var) {
			if(factor_designator.getDesignator().obj.getType().getKind() == Struct.Class ||
			   factor_designator.getDesignator().obj.getType().getKind() == Struct.Array) 
			{
				// Ne javljaj nista, to ce biti odradjeno kasnije
			}
			else {
				// U pitanju je pristup promenljivoj
				report_info("Pristup promenljivoj " + factor_designator.getDesignator().obj.getName(), factor_designator);
			}
		}
	}
	
	@Override
	public void visit(Factor_newNiz factor_newNiz) {
		if(factor_newNiz.getExpr().struct != Tab.intType) {
			factor_newNiz.struct = Tab.noType;
			report_error("Niz se ne moze inicijalizovati sa necim sto nije tipa int", factor_newNiz);
			return;
		}
		
		factor_newNiz.struct = new Struct(Struct.Array, factor_newNiz.getType().struct);
	}
	
	/*Posecivanje new Skup*/
	
	@Override
	public void visit(Factor_newSkup factor_newSkup) {
		if(factor_newSkup.getExpr().struct != Tab.intType) {
			factor_newSkup.struct = Tab.noType;
			report_error("Skup se ne moze inicijalizovati sa necim sto nije tipa int", factor_newSkup);
			return;
		}
		
		factor_newSkup.struct = new TypeSet(TypeSet.Set);
	}
	
	// Pozivanje metoda
	
	@Override
	public void visit(ImePozivaneMetode imePozivaneMetode) {
		
		imePozivaneMetode.obj = imePozivaneMetode.getDesignator().obj;
		// U listu na vrhu steka cemo stavljati stvarne parametre metode
		this.stekStvarnihParametara.push(new ArrayList<Struct>());
	}
	
	@Override
	public void visit(ActPars_listaIzraza actPars_listaIzraza) {
		
		// Samo dodamo parametar u listu koja je na vrhu steka
		this.stekStvarnihParametara.peek().add(actPars_listaIzraza.getExpr().struct);
	}
	
	@Override
	public void visit(ActPars_jedanIzraz actPars_jedanIzraz) {
		
		// Samo dodamo parametar u listu koja je na vrhu steka
		this.stekStvarnihParametara.peek().add(actPars_jedanIzraz.getExpr().struct);
	}
	
	// Pravimo metodu u kojoj cemo proveriti da li se argumenti funkcije
	// slazu sa stvarnim argumentima funkcije 
	
	private List<Obj> proveriStvarneArgumente(Obj cvorFunkcije, int brojStvarnihArgumenata, SyntaxNode info) {
		
		List<Obj> formalniArgumenti = new ArrayList<Obj>();
		
		for(Obj cvor: cvorFunkcije.getLocalSymbols()) {
			if(cvor.getFpPos() == 1) {
				formalniArgumenti.add(cvor);
			}
		}
		
		int brojFormalnihArgumenata = cvorFunkcije.getLevel();
		
		if(brojFormalnihArgumenata == brojStvarnihArgumenata) {
			return formalniArgumenti;
		}
		
		report_error("Broj stvarnih (" + brojStvarnihArgumenata + ") i formalnih (" + brojFormalnihArgumenata + ") argumenata funkcije " + cvorFunkcije.getName() + " mora biti isti. ", info);
		return null;
	}
	
	private Struct proveriPoklapanjeArgumenata(Obj cvorFunkcije, SyntaxNode info) {
		
		if(cvorFunkcije.getKind() != Obj.Meth) {
			report_error(cvorFunkcije.getName() + " ne predstavlja funkciju. ", info);
			return Tab.noType;
		}
		
		List<Struct> stvarniParametriFunkcije = this.stekStvarnihParametara.pop();
		int brojParametara = stvarniParametriFunkcije.size();
		
		List<Obj> formalniParametriFunkcije = this.proveriStvarneArgumente(cvorFunkcije, brojParametara, info);
		
		if(formalniParametriFunkcije == null) {
			return Tab.noType;
		}
		
		for(int i = 0; i < brojParametara; i++) {
			if(!stvarniParametriFunkcije.get(i).assignableTo(formalniParametriFunkcije.get(i).getType())) {
				report_error("Formalnom argumentu na poziciji " + (i + 1)  + " se ne moze dodeliti stvarni argument na toj poziciji. ", info);
    			return Tab.noType;
			}
		}
		
		report_info("Poziv funkcije " + cvorFunkcije.getName() + ". ", info);
		return cvorFunkcije.getType();
	}
	
	@Override
	public void visit(Factor_pozivMetode factor_pozivMetode) {
		factor_pozivMetode.struct = this.proveriPoklapanjeArgumenata(factor_pozivMetode.getImePozivaneMetode().obj, factor_pozivMetode);
	}
	
	@Override
	public void visit(DesignatorStatement_pozivMetode designatorStatement_pozivMetode) {
		this.proveriPoklapanjeArgumenata(designatorStatement_pozivMetode.getImePozivaneMetode().obj, designatorStatement_pozivMetode);
	}
	
	
	
	@Override
	public void visit(FactorList_jedanFaktor factorList_jedanFaktor) {
		factorList_jedanFaktor.struct = factorList_jedanFaktor.getFactor().struct;
	}
	
	@Override
	public void visit(FactorList_listaFaktora factorList_listaFaktora) {
		if(factorList_listaFaktora.getFactor().struct != Tab.intType ||
				factorList_listaFaktora.getFactorList().struct != Tab.intType	)
		{
			report_error("Tip svih cinilaca mora biti int. ", factorList_listaFaktora);
			factorList_listaFaktora.struct = Tab.noType;
			return;
		}
		
		factorList_listaFaktora.struct = Tab.intType;
	}
	
	@Override
	public void visit(Term term) {
		term.struct = term.getFactorList().struct;
	}
	
	@Override 
	public void visit(AddopList_jedanTerm addopList_jedanTerm) {
		addopList_jedanTerm.struct = addopList_jedanTerm.getTerm().struct;
	}
	
	@Override 
	public void visit(AddopList_listaTermova addopList_listaTermova) {
		
		if(!addopList_listaTermova.getTerm().struct.compatibleWith(addopList_listaTermova.getAddopList().struct)){
			report_error("Tipovi svih sabiraka moraju biti kompatibilni. ", addopList_listaTermova);
			addopList_listaTermova.struct = Tab.noType;
			return;
		}
		if(addopList_listaTermova.getTerm().struct != Tab.intType || addopList_listaTermova.getAddopList().struct != Tab.intType){
			report_error("Svi sabirci moraju biti tipa int. ", addopList_listaTermova);
			addopList_listaTermova.struct = Tab.noType;
			return;
		}
		
		addopList_listaTermova.struct = Tab.intType;
	}
	
	@Override
	public void visit(AddopList_minus expr_minusIspredListe) {
		if(expr_minusIspredListe.getTerm().struct != Tab.intType) {
			report_error("Tip negiranog izraza mora biti int. ", expr_minusIspredListe);
			expr_minusIspredListe.struct = Tab.noType;
			return;
		}
		
		expr_minusIspredListe.struct = Tab.intType;
	}
	
	@Override
	public void visit(Expr_lista expr_lista) {
		expr_lista.struct = expr_lista.getAddopList().struct;
	}
	
	@Override
	public void visit(Expr_map expr_map) {
		Obj funkcija = expr_map.getDesignator().obj;
		Obj niz = expr_map.getDesignator1().obj;
		
		if(funkcija.getKind() != Obj.Meth) {
			report_error("Kod MAP iskaza levi operand mora biti funkcija. ", expr_map);
			expr_map.struct = Tab.noType;
			return;
		}
		if(funkcija.getType() != Tab.intType) {
			report_error("Kod MAP iskaza levi operand mora biti funkcija koja vraca tip int. ", expr_map);
			expr_map.struct = Tab.noType;
			return;
		}
		if(funkcija.getLevel() != 1) {
			report_error("Kod MAP iskaza funcija mora da prima tacno jedan parametar. ", expr_map);
			expr_map.struct = Tab.noType;
			return;
		}
		// Ova petlja ce se izvrsiti tacno jednom
		for(Obj param: funkcija.getLocalSymbols()) {
			if(param.getType() != Tab.intType) {
				report_error("Kod MAP iskaza funcija mora da prima parametar tipa int. ", expr_map);
				expr_map.struct = Tab.noType;
				return;
			}
		}
		
		if(niz.getType().getKind() != Struct.Array) {
			report_error("Kod MAP iskaza sa desne strane mora niz. ", expr_map);
			expr_map.struct = Tab.noType;
			return;
		}
		
		if(niz.getType().getElemType() != Tab.intType) {
			report_error("Kod MAP iskaza sa desne strane mora niz ciji su elementi tipa int. ", expr_map);
			expr_map.struct = Tab.noType;
			return;
		}
		
		expr_map.struct = Tab.intType;
	}
	
	/* Obrada return*/
	@Override
	public void visit(Statement_returnExpr statement_returnExpr) {
		this.returnPronadjen = true;
		
		if(this.trenutnaMetoda.getType() == Tab.noType) {
			report_error("Funkcija " + this.trenutnaMetoda.getName() + " je tipa void, ne sme da ima izraz u return naredbi. ", statement_returnExpr);
			return;
		}
		if(!this.trenutnaMetoda.getType().equals(statement_returnExpr.getExpr().struct)) {
			report_error("Povratna vrednost funkcije " + this.trenutnaMetoda.getName() + " nije odgovarajuceg tipa. ", statement_returnExpr);
			return;
		}

	}
	
	@Override
	public void visit(Statement_return statement_return) {
		this.returnPronadjen = true;
		
		if(this.trenutnaMetoda.getType() != Tab.noType) {
			report_error("Funkcija " + this.trenutnaMetoda.getName() + " ima povratnu vrednost, u return naredbi mora postojati izraz. ", statement_return);
			return;
		}
		
	}
	
	/* Obrada designatora*/
	
	@Override
	public void visit(Designator_ident designator_ident) {
		Obj cvorDesignator = Tab.find(designator_ident.getI1());
		
		if(cvorDesignator == Tab.noObj) {
			report_error("Promenljiva " + designator_ident.getI1() + " nije deklarisana. ", designator_ident);
			// Tab.noObj ce propagirati dalje
		}
		
		designator_ident.obj = cvorDesignator;
	}
	
	@Override
	public void visit(Designator_niz designator_niz) {
		if(designator_niz.getImeNizaDesignator().getDesignator().obj.getType().getKind() != Struct.Array) {
			report_error("Promenljiva " + designator_niz.getImeNizaDesignator().getDesignator().obj.getName() + " nije nizovskog tipa. ", designator_niz);
			designator_niz.obj = Tab.noObj;
			return;
		}
		
		if(designator_niz.getExpr().struct != Tab.intType) {
			report_error("Indeks niza " + designator_niz.getImeNizaDesignator().getDesignator().obj.getName() + " mora biti tipa int. ", designator_niz);
			designator_niz.obj = Tab.noObj;
			return;
		}
		
		report_info("Pristup elementu niza "  + designator_niz.getImeNizaDesignator().getDesignator().obj.getName() , designator_niz);
		
		// Mi ovde prosledimo ne tip niza, nego tip elementa niza
		designator_niz.obj = new Obj(Obj.Elem, designator_niz.getImeNizaDesignator().getDesignator().obj.getName(), designator_niz.getImeNizaDesignator().getDesignator().obj.getType().getElemType());
	}
	
	
	@Override
	public void visit(DesignatorStatement_expr designatorStatement_expr) {
		Obj dst = designatorStatement_expr.getDesignator().obj;
		Struct src = designatorStatement_expr.getExpr().struct;
		
		if(dst.getKind() != Obj.Var && dst.getKind() != Obj.Elem && dst.getKind() != Obj.Fld ) {
			report_error("Leva strana jednakosti mora biti promenljiva, element niza ili polje klase. ", designatorStatement_expr);
			return;
		}
		
		if(!dst.getType().assignableTo(src)) {
			report_error("Desna strana izraza nije dodeljiva levoj strani (" + dst.getName() + "). ", designatorStatement_expr);
			return;
		}
	}
	
	@Override
	public void visit(DesignatorStatement_inkrement designatorStatement_inkrement) {
		Obj dst = designatorStatement_inkrement.getDesignator().obj;
		
		if(dst.getKind() != Obj.Var && dst.getKind() != Obj.Elem && dst.getKind() != Obj.Fld ) {
			report_error("Inkrementiranje se vrsi nad promenljivom, elementom niza ili poljem klase. ", designatorStatement_inkrement);
			return;
		}
		
		if(dst.getType() != Tab.intType) {
			report_error("Inkrementiranje mora biti nad promenljivom tipa int. ", designatorStatement_inkrement);
			return;
		}
	}
	
	@Override
	public void visit(DesignatorStatement_dekrement designatorStatement_dekrement) {
		Obj dst = designatorStatement_dekrement.getDesignator().obj;
		
		if(dst.getKind() != Obj.Var && dst.getKind() != Obj.Elem && dst.getKind() != Obj.Fld ) {
			report_error("Dekrementiranje se vrsi nad promenljivom, elementom niza ili poljem klase. ", designatorStatement_dekrement);
			return;
		}
		
		if(dst.getType() != Tab.intType) {
			report_error("Dekrementiranje mora biti nad promenljivom tipa int. ", designatorStatement_dekrement);
			return;
		}
	}
	
	// TODO: DesignatorStatement_operacijaSaSkupovima
	
	@Override
	public void visit(DesignatorStatement_operacijaSaSkupovima designatorStatement_operacijaSaSkupovima) {
		Struct prvi = designatorStatement_operacijaSaSkupovima.getDesignator().obj.getType();
		Struct drugi = designatorStatement_operacijaSaSkupovima.getDesignator1().obj.getType();
		Struct treci = designatorStatement_operacijaSaSkupovima.getDesignator2().obj.getType();
		
		if(prvi.getKind() != TypeSet.Set || drugi.getKind() != TypeSet.Set || treci.getKind() != TypeSet.Set) {
			report_error("Kod operacija sa skupovima svi operandi moraju biti tipa set. ", designatorStatement_operacijaSaSkupovima);
			return;
		}
	}
	
	/* do while obrada*/
	
	@Override
	public void visit(PocetakDoWhileBloka pocetakDoWhileBloka) {
		this.dubinaDoWhilePetlje++;
	}
	
	@Override
	public void visit(Statement_doWhile statement_doWhile) {
		this.dubinaDoWhilePetlje--;
	}
	
	@Override
	public void visit(Statement_break statement_break) {
		if(this.dubinaDoWhilePetlje == 0) {
			report_error("BREAK naredba mora biti pozvana unutar petlje. ", statement_break);
			return;
		}
	}
	
	@Override
	public void visit(Statement_continue statement_continue) {
		if(this.dubinaDoWhilePetlje == 0) {
			report_error("CONTINUE naredba mora biti pozvana unutar petlje. ", statement_continue);
			return;
		}
	}
	
	
	/* Obrada uslova */
	
	@Override
	public void visit(CondFact_jedanIzraz condFact_jedanIzraz) {
		if(condFact_jedanIzraz.getExpr().struct != this.boolType) {
			report_error("Uslov mora biti tipa bool. ", condFact_jedanIzraz);
		}
	}
	
	@Override
	public void visit(CondFact_listaIzraza condFact_listaIzraza) {
		Struct levi = condFact_listaIzraza.getExpr().struct;
		Struct desni = condFact_listaIzraza.getExpr1().struct;
		
		if(!levi.compatibleWith(desni)) {
			report_error("Izrazi moraju biti uporedivi. ", condFact_listaIzraza);
			return;
		}
		
		if(levi.getKind() == Struct.Array || desni.getKind() == Struct.Array 
		   || levi.getKind() == Struct.Class || desni.getKind() == Struct.Class
		   || levi.getKind() == TypeSet.Set || desni.getKind() == TypeSet.Set)
		{
			if(!this.relacioniOperator.equals(RelacioniOperator.JEDNAKO) && 
					!this.relacioniOperator.equals(RelacioniOperator.RAZLICITO))
			{
				report_error("Ako su u pitanju reference jedine dve dozvoljene operacije su '==' i '!=' ", condFact_listaIzraza);
			}
				
		}
	}
	
	
	/* obrada print-a*/
	
	@Override
	public void visit(Statement_print statement_print) {
		Struct tip = statement_print.getExpr().struct;
		if(tip != Tab.intType && tip != Tab.charType && tip != this.boolType && tip != this.typeSet) {
			report_error("Print funckija se moze pozvati za tipove: int, char, bool ili set. ", statement_print);
			return;
		}
	}
	
	@Override
	public void visit(Statement_printNumber statement_printNumber) {
		Struct tip = statement_printNumber.getExpr().struct;
		if(tip != Tab.intType && tip != Tab.charType && tip != this.boolType /*dodati uslov za tip skupa*/) {
			report_error("Print funckija se moze pozvati za tipove: int, char, bool ili set. ", statement_printNumber);
			return;
		}
	}
	
	/* obrada read-a*/
	
	@Override
	public void visit(Statement_read statement_read) {
		Struct dst = statement_read.getDesignator().obj.getType();
		
		if(dst.getKind() != Obj.Var && dst.getKind() != Obj.Elem && dst.getKind() != Obj.Fld ) {
			report_error("Ucitavanje se vrsi u promenljivu, element niza ili polje klase. ", statement_read);
			return;
		}
		
		if(dst != Tab.intType && dst != Tab.charType && dst != this.boolType ) {
			report_error("Ucitavanje se vrsi u int, char ili bool promenljivu. ", statement_read);
			return;
		}
	}
	
	/* Obrada operacija */
	
	@Override
	public void visit(Relop_jednakoJednako relop_jednakoJednako) {
		this.relacioniOperator = RelacioniOperator.JEDNAKO;
	}
	
	@Override
	public void visit(Relop_razlicito relop_razlicito) {
		this.relacioniOperator = RelacioniOperator.RAZLICITO;
	}
	
	@Override
	public void visit(Relop_manjeJednako relop_manjeJednako) {
		this.relacioniOperator = RelacioniOperator.MANJE_JEDNAKO;
	}
	
	@Override
	public void visit(Relop_veceJednako relop_veceJednako) {
		this.relacioniOperator = RelacioniOperator.VECE_JEDNAKO;
	}
	
	@Override
	public void visit(Relop_manje relop_manje) {
		this.relacioniOperator = RelacioniOperator.MANJE;
	}
	
	@Override
	public void visit(Relop_vece relop_vece) {
		this.relacioniOperator = RelacioniOperator.VECE;
	}
	
	
	public boolean passed() {
		return !errorDetected;
	}
}
