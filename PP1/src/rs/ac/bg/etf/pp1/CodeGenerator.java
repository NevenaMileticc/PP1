package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class CodeGenerator extends VisitorAdaptor {
	
	private int mainPc;
	
	public int getmainPc() {
		return this.mainPc;
	}
	
	private Stack<Obj> ugnjezdeniPoziviFunkcija = new Stack<Obj>();
	
	
	private void kodZaLen() {
		Code.put(Code.arraylength);
	}
	
	private void kodZaAdd() {
		Code.put(Code.const_1);
		Code.put(Code.store_3);
		Code.put(Code.const_1);
		Code.put(Code.store_2);
		Code.put(Code.load_2);
		Code.put(Code.load_n);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.le);
		Code.put2(6);
		Code.put(Code.jmp);
		Code.put2(29);
		Code.put(Code.load_n);
		Code.put(Code.load_2);
		Code.put(Code.aload);
		Code.put(Code.load_1);
		Code.put(Code.jcc + Code.ne);
		Code.put2(8);
		Code.put(Code.const_n);
		Code.put(Code.store_3);
		Code.put(Code.jmp);
		Code.put2(17);
		Code.put(Code.load_2);
		Code.put(Code.load_n);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_2);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_2);
		Code.put(Code.jmp);
		Code.put2(-33);
		Code.put(Code.load_3);
		Code.put(Code.const_1);
		Code.put(Code.jcc + Code.ne);
		Code.put2(16);
		Code.put(Code.load_n);
		Code.put(Code.const_n);
		Code.put(Code.dup2);
		Code.put(Code.aload);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.astore);
		Code.put(Code.load_n);
		Code.put(Code.load_n);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.load_1);
		Code.put(Code.astore);
	}
	
	private void kodZaAddAll() {
		Code.put(Code.const_n);
		Code.put(Code.store_2);
		Code.put(Code.load_n);
		Code.put(Code.load_1);
		Code.put(Code.load_2);
		Code.put(Code.aload);
		
		Obj add = Tab.find("add");
		int offset = add.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		Code.put(Code.load_2);
		Code.put(Code.load_1);
		Code.put(Code.arraylength);
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_2);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_2);
		Code.put(Code.jmp);
		Code.put2(-19);
		
	}
	
	private void kodZaUnion() {
		Code.put(Code.const_1);
		Code.put(Code.store_3);
		Code.put(Code.load_3);
		Code.put(Code.load_1);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.le);
		Code.put2(6);
		Code.put(Code.jmp);
		Code.put2(24);
		Code.put(Code.load_n);
		Code.put(Code.load_1);
		Code.put(Code.load_3);
		Code.put(Code.aload);
		
		Obj add = Tab.find("add");
		int offset = add.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		Code.put(Code.load_3);
		Code.put(Code.load_1);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_3);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_3);
		Code.put(Code.jmp);
		Code.put2(-28);
		Code.put(Code.const_1);
		Code.put(Code.store_3);
		Code.put(Code.load_3);
		Code.put(Code.load_2);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.le);
		Code.put2(6);
		Code.put(Code.jmp);
		Code.put2(24);
		Code.put(Code.load_n);
		Code.put(Code.load_2);
		Code.put(Code.load_3);
		Code.put(Code.aload);
		
		add = Tab.find("add");
		offset = add.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		Code.put(Code.load_3);
		Code.put(Code.load_2);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_3);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_3);
		Code.put(Code.jmp);
		Code.put2(-28);
	}
	
	private void kodZaMap(int adresaFunkcije) {
		Code.put(Code.const_n);
		Code.put(Code.store_2);
		Code.put(Code.const_n);
		Code.put(Code.store_1);
		Code.put(Code.load_2);
		Code.put(Code.load_n);
		Code.put(Code.load_1);
		Code.put(Code.aload);
		
		int offset = adresaFunkcije - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		Code.put(Code.add);
		Code.put(Code.store_2);
		Code.put(Code.load_1);
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		Code.put(Code.const_1);
		Code.put(Code.sub);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_1);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_1);
		Code.put(Code.jmp);
		Code.put2(-21);
		Code.put(Code.load_2);
		
	}
	
	private void kodZaIspisSkupa() {

		Code.put(Code.const_1); 
		Code.put(Code.store_1);
		Code.put(Code.load_n);
		Code.put(Code.load_1);
		Code.put(Code.aload);
		Code.put(Code.const_1);
		Code.put(Code.print);
		Code.put(Code.const_);
		Code.put4(32);
		Code.put(Code.const_1);
		Code.put(Code.bprint);
		Code.put(Code.load_1);
		Code.put(Code.load_n);
		Code.put(Code.const_n);
		Code.put(Code.aload);
		Code.put(Code.jcc + Code.ge);
		Code.put2(10);
		Code.put(Code.load_1);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.store_1);
		Code.put(Code.jmp);
		Code.put2(-23);
		Code.put(Code.const_);
		Code.put4(10);
		Code.put(Code.const_1);
		Code.put(Code.bprint);
	}
	
	public void inicijalizujPredeklarisaneMetode() {
		Obj add = Tab.find("add");
		add.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2);
		Code.put(4);
		
		this.kodZaAdd();
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Obj addAll = Tab.find("addAll");
		addAll.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(2);
		Code.put(3);
		
		this.kodZaAddAll();
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		// Pomocna metoda za union 
		
		Obj methObj;
		Tab.currentScope.addToLocals(methObj = new Obj(Obj.Meth, "union", Tab.noType, 0, 2));
		{
			Tab.openScope();
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "s1", Tab.find("set").getType(), 0, 1));
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "s2", new Struct(Struct.Array, Tab.intType), 0, 1));
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "s3", new Struct(Struct.Array, Tab.intType), 0, 1));
			methObj.setLocals(Tab.currentScope.getLocals());
			Tab.closeScope();
		}
		Obj union = Tab.find("union");
		union.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(3);
		Code.put(4);
		
		this.kodZaUnion();
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		// Pomocna metoda za ispis skupa 
		
		Tab.currentScope.addToLocals(methObj = new Obj(Obj.Meth, "printSet", Tab.noType, 0, 2));
		{
			Tab.openScope();
			Tab.currentScope.addToLocals(new Obj(Obj.Var, "s1", Tab.find("set").getType(), 0, 1));
			methObj.setLocals(Tab.currentScope.getLocals());
			Tab.closeScope();
		}
		Obj printSet = Tab.find("printSet");
		printSet.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(1);
		Code.put(2);
		
		this.kodZaIspisSkupa();
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		
	}
	
	
	@Override
	public void visit(MethodSignature methodSignature) {
		methodSignature.obj.setAdr(Code.pc);
		
		if("main".equals(methodSignature.getI2())){
			this.mainPc = Code.pc;
		}
		
		Code.put(Code.enter);
		Code.put(methodSignature.obj.getLevel());
		Code.put(methodSignature.obj.getLocalSymbols().size());
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* print */
	
	@Override
	public void visit(Statement_print statement_print) {
		if(statement_print.getExpr().struct == Tab.find("set").getType()) {
			Obj printSet = Tab.find("printSet");
			int offset = printSet.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);
		}
		else if(statement_print.getExpr().struct == Tab.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		else {
			Code.loadConst(1);
			Code.put(Code.print);
		}
	}
	
	@Override
	public void visit(Statement_printNumber statement_print) {
		Code.loadConst(statement_print.getN2());
		if(statement_print.getExpr().struct == Tab.charType) {
			Code.put(Code.bprint);
		}
		else {
			Code.put(Code.print);
		}
	}
	
	/* read */
	@Override
	public void visit(Statement_read statement_read) {
		if(statement_read.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		
		Code.store(statement_read.getDesignator().obj);
	}
	
	/* return */
	
	@Override
	public void visit(Statement_return statement_return) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Statement_returnExpr statement_returnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/* poziv metode*/
	
	@Override
	public void visit(ImePozivaneMetode imePozivaneMetode) {
		this.ugnjezdeniPoziviFunkcija.push(imePozivaneMetode.obj);
		
	}
	
	
	@Override
	public void visit(Factor_pozivMetode factor_pozivMetode) {
		
		Obj cvorMetode = factor_pozivMetode.getImePozivaneMetode().obj;
		
		if("len".equals(cvorMetode.getName())) {
			this.kodZaLen();
			return;
		}
		if("chr".equals(cvorMetode.getName())) {
			// Kod za ovo nema potrebe dodavati
			return;
		}
		if("ord".equals(cvorMetode.getName())) {
			// Kod za ovo nema potrebe dodavati
			return;
		}
		
		
		int offset = cvorMetode.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		this.ugnjezdeniPoziviFunkcija.pop();
	}
	
	@Override
	public void visit(DesignatorStatement_pozivMetode designatorStatement_pozivMetode) {
		Obj cvorMetode = designatorStatement_pozivMetode.getImePozivaneMetode().obj;
		
		if("len".equals(cvorMetode.getName())) {
			this.kodZaLen();
			if(cvorMetode.getType() != Tab.noType) {
				Code.put(Code.pop);
			}
			return;
		}
		if("chr".equals(cvorMetode.getName())) {
			// Kod za ovo nema potrebe dodavati
			return;
		}
		if("ord".equals(cvorMetode.getName())) {
			// Kod za ovo nema potrebe dodavati
			return;
		}
		
		int offset = cvorMetode.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		if(cvorMetode.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
		
		this.ugnjezdeniPoziviFunkcija.pop();
	}
	
	
	/* Factor */
	@Override
	public void visit(Factor_int factor_int) {
		Obj tmpCon = Tab.insert(Obj.Con, "privremena", Tab.intType);
		tmpCon.setLevel(0);
		tmpCon.setAdr(factor_int.getN1());
		
		Code.load(tmpCon);
	}
	@Override
	public void visit(Factor_bool factor_bool) {
		Obj tmpCon = Tab.insert(Obj.Con, "privremena", Tab.intType);
		tmpCon.setLevel(0);
		if(factor_bool.getB1() == true) {
			tmpCon.setAdr(1);
		}
		else {
			tmpCon.setAdr(0);
		}
		
		
		Code.load(tmpCon);
	}
	
	@Override
	public void visit(Factor_char factor_char) {
		Obj tmpCon = Tab.insert(Obj.Con, "privremena", Tab.intType);
		tmpCon.setLevel(0);
		tmpCon.setAdr(factor_char.getC1());
		
		Code.load(tmpCon);
	}
	
	@Override
	public void visit(Expr_map expr_map) {
		
		
		Code.load(expr_map.getDesignator1().obj);
		Code.put(Code.call);
		Code.put2(6);   // Jer je 6 pomeraj do enter instrukcije 
		Code.put(Code.jmp);
		Code.put2(37); // Jer je 37 pomeraj do posle return instrukcije
		
		Code.put(Code.enter);
		Code.put(1);
		Code.put(3);
		
		this.kodZaMap(expr_map.getDesignator().obj.getAdr());
		
		Code.put(Code.exit);
		Code.put(Code.return_); // Sa jmp poramo da skocimo iza ove instrukcije 
	}
	
	@Override
	public void visit(AddopList_minus expr_minusIspredListe) {
		Code.put(Code.neg);
	}
	
	@Override
	public void visit(AddopList_listaTermova addopList_listaTermova) {
		if(addopList_listaTermova.getAddop() instanceof Addop_plus) {
			Code.put(Code.add);
		}
		else {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(FactorList_listaFaktora factorList_listaFaktora) {
		
		if(factorList_listaFaktora.getMulop() instanceof Mulop_puta) {
			Code.put(Code.mul);
		}
		else if(factorList_listaFaktora.getMulop() instanceof Mulop_podeljeno) {
			Code.put(Code.div);
		}
		else {
			Code.put(Code.rem);
		}
	}
	
	/* Designator */
	
	@Override
	public void visit(ImeNizaDesignator imeNizaDesignator) {
		Code.load(imeNizaDesignator.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_inkrement designatorStatement_inkrement) {
		if(designatorStatement_inkrement.getDesignator().obj.getKind() == Obj.Var) {
			Code.load(designatorStatement_inkrement.getDesignator().obj);
		}
		else if(designatorStatement_inkrement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
			Code.load(designatorStatement_inkrement.getDesignator().obj);
		}
		
		Code.loadConst(1);
		Code.put(Code.add);
		
		Code.store(designatorStatement_inkrement.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_dekrement designatorStatement_dekrement) {
		if(designatorStatement_dekrement.getDesignator().obj.getKind() == Obj.Var) {
			Code.load(designatorStatement_dekrement.getDesignator().obj);
		}
		else if(designatorStatement_dekrement.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
			Code.load(designatorStatement_dekrement.getDesignator().obj);
		}
		
		Code.loadConst(1);
		Code.put(Code.sub);
		
		Code.store(designatorStatement_dekrement.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_expr designatorStatement_expr) {
		Code.store(designatorStatement_expr.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_operacijaSaSkupovima designatorStatement_operacijaSaSkupovima) {
		Obj prvi = designatorStatement_operacijaSaSkupovima.getDesignator().obj;
		Obj drugi = designatorStatement_operacijaSaSkupovima.getDesignator1().obj;
		Obj treci = designatorStatement_operacijaSaSkupovima.getDesignator2().obj;
		
		Code.load(prvi);
		Code.load(drugi);
		Code.load(treci);
		Obj union = Tab.find("union");
		int offset = union.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		
	}
	
	@Override
	public void visit(Factor_designator factor_designator) {
		Code.load(factor_designator.getDesignator().obj);
	}
	
	@Override
	public void visit(Factor_newNiz factor_newNiz) {
		
		Code.put(Code.newarray);
		
		if(factor_newNiz.struct.getElemType() == Tab.charType) {
			Code.put(0);
		}
		else {
			Code.put(1);
		}
		
	}
	
	@Override
	public void visit(Factor_newSkup factor_newskup) {
		// Alociramo skup kao niz gde ce prvi element tog niza cuvato popunjenost skupa 
		Code.loadConst(1);
		Code.put(Code.add);
		Code.put(Code.newarray);
		Code.put(1);
	}
	
	
	/* obrada uslova za if else i do while*/
	
	private Stack<List<Integer>> adresePopravkaOrUslova = new Stack<List<Integer>>();
	
	private Stack<List<Integer>> adresePopravkaAndUslova = new Stack<List<Integer>>();
	
	private Stack<List<Integer>> adresePopravkaBezuslovnogSkokaPosleThenBloka = new Stack<List<Integer>>();
	
	
	// za do-while
	private Stack<Integer> startDoWhileAdresePopravka = new Stack<Integer>();
	
	// Za break
	private Stack<List<Integer>> adresePopravkaPocetkaNonDoWhileBloka = new Stack<List<Integer>>();
	
	// Za continue
	private Stack<List<Integer>> adresePopravkaPocetkaDoWhileUslova = new Stack<List<Integer>>();
	
	
	@Override
	public void visit(PocetakIfUslova pocetakIfUslova) {
		this.adresePopravkaAndUslova.push(new ArrayList<Integer>());
		this.adresePopravkaOrUslova.push(new ArrayList<Integer>());
		this.adresePopravkaBezuslovnogSkokaPosleThenBloka.push(new ArrayList<Integer>());
	}
	
	// Obradjujemo AND blok uslova 
	
	@Override
	public void visit(CondFact_jedanIzraz condFact_jedanIzraz) {
		
		// Treba da vidimo da li je ovaj izraz tacan ili netacan
		// Tacan je ako je 1 netacan je ako je 0
		
		Code.loadConst(1);
		Code.putFalseJump(Code.eq, 0);
		
		adresePopravkaAndUslova.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(CondFact_listaIzraza condFact_listaIzraza) {
		// Stek:
		// int
		// int 
		// Moramo da uporedimo ova dva inta
		
		if(condFact_listaIzraza.getRelop() instanceof Relop_jednakoJednako) {
			Code.putFalseJump(Code.eq, 0);
		}
		else if(condFact_listaIzraza.getRelop() instanceof Relop_razlicito) {
			Code.putFalseJump(Code.ne, 0);
		}
		else if(condFact_listaIzraza.getRelop() instanceof Relop_manjeJednako) {
			Code.putFalseJump(Code.le, 0);
		}
		else if(condFact_listaIzraza.getRelop() instanceof Relop_veceJednako) {
			Code.putFalseJump(Code.ge, 0);
		}
		else if(condFact_listaIzraza.getRelop() instanceof Relop_manje) {
			Code.putFalseJump(Code.lt, 0);
		}
		else if(condFact_listaIzraza.getRelop() instanceof Relop_vece) {
			Code.putFalseJump(Code.gt, 0);
		}
		else {
			return;
		}
		
		adresePopravkaAndUslova.peek().add(Code.pc - 2);
	}
	
	@Override
	public void visit(KrajIfUslova krajIfUslova) {
		// Kraj poslednjeg OR bloka
		// Odmah ispod je pocetak then bloka pa treba popraviti or adrese koje treba da skoce na taj blok
		
		for(int adresa: adresePopravkaOrUslova.peek()) {
			Code.fixup(adresa);
		}
		
		 adresePopravkaOrUslova.peek().clear();
	}
	
	@Override
	public void visit(KrajIliNaredbe krajIliNaredbe) {
		
		// Ako sam dosao dovde, znaci da je ILI blok tacan pa bezuslovno skacem na then granu
		
		Code.putJump(0);
		this.adresePopravkaOrUslova.peek().add(Code.pc - 2);
		
		// Ispred nas je novi OR blok pa treba zakrpiti adrese iz netacnih AND blokova
		
		for(int adresa: this.adresePopravkaAndUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaAndUslova.peek().clear();
	}
	
	@Override
	public void visit(PocetakElseBloka pocetakElseBloka) {
		// Odavde tacni treba bezuslovno da skoce na kraj IF-ELSE naredbe, a ovde treba popraviti one koji su netacni
		
		if(pocetakElseBloka.getParent() instanceof Statement_ifElse) {
			// Znaci imamo ispod nas else blok pa treba da skovimo bezuslovno
			Code.putJump(0);
			this.adresePopravkaBezuslovnogSkokaPosleThenBloka.peek().add(Code.pc - 2);
		}
		
		// Sad treba da popravimo sve one netacne koji su trebali da skoce na else blok
		for(int adresa: this.adresePopravkaAndUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaAndUslova.peek().clear();
		
	}
	
	@Override
	public void visit(Statement_if statement_if) {
		
		// Zatvorimo sve
		this.adresePopravkaAndUslova.pop();
		this.adresePopravkaOrUslova.pop();
		this.adresePopravkaBezuslovnogSkokaPosleThenBloka.pop();
	}
	
	@Override
	public void visit(Statement_ifElse statement_ifElse) {
		
		// Ovde znam kraj else bloka pa treba da popravim one sto su trebali da ga preskoce
		for(int adresa: this.adresePopravkaBezuslovnogSkokaPosleThenBloka.peek()) {
			Code.fixup(adresa);
		}
		
		this.adresePopravkaBezuslovnogSkokaPosleThenBloka.peek().clear();
		
		// Zatvorimo sve
		this.adresePopravkaAndUslova.pop();
		this.adresePopravkaOrUslova.pop();
		this.adresePopravkaBezuslovnogSkokaPosleThenBloka.pop();
	}
	
	/* obrada do-while */
	
	@Override
	public void visit(PocetakDoWhileBloka pocetakDoWhileBloka) {
		
		this.adresePopravkaAndUslova.push(new ArrayList<Integer>());
		this.adresePopravkaOrUslova.push(new ArrayList<Integer>());
		
		this.startDoWhileAdresePopravka.push(Code.pc);
		
		this.adresePopravkaPocetkaDoWhileUslova.push(new ArrayList<Integer>());
		this.adresePopravkaPocetkaNonDoWhileBloka.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(PocetakDoWhileUslova pocetakDoWhileUslova) {
		// Ovde moram da popravim sve continue
		for(int adresa: this.adresePopravkaPocetkaDoWhileUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaPocetkaDoWhileUslova.peek().clear();
	}
	
	@Override
	public void visit(KrajDoWhileUslova krajDoWhileUslova) {
		
		for(int adresa: adresePopravkaOrUslova.peek()) {
			Code.fixup(adresa);
		}
		
		 adresePopravkaOrUslova.peek().clear();
		 
		 
	}
	
	@Override
	public void visit(SaBocnimEfektom saBocnimEfektom) {
		// Ovde treba bezuslovno da skocim na pocetak petlje
		Code.putJump(this.startDoWhileAdresePopravka.peek());
		
		// Ovde treba popraviti sve koji treba da iskoce iz petlje, kao i one sto rade break
		for(int adresa: this.adresePopravkaAndUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaAndUslova.peek().clear();
	
		// Popravimo ove sto cekaju break
		
		for(int adresa: this.adresePopravkaPocetkaNonDoWhileBloka.peek()) {
				Code.fixup(adresa);
			}
		 this.adresePopravkaPocetkaNonDoWhileBloka.peek().clear();
		
	}
	
	@Override
	public void visit(BezBocnogEfekta bezBocnogEfekta) {
		// Ovde treba bezuslovno da skocim na pocetak petlje
		Code.putJump(this.startDoWhileAdresePopravka.peek());
		
		// Ovde treba popraviti sve koji treba da iskoce iz petlje, kao i one sto rade break
		for(int adresa: this.adresePopravkaAndUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaAndUslova.peek().clear();
	
		// Popravimo ove sto cekaju break
		
		for(int adresa: this.adresePopravkaPocetkaNonDoWhileBloka.peek()) {
				Code.fixup(adresa);
			}
		 this.adresePopravkaPocetkaNonDoWhileBloka.peek().clear();
		
	}
	
	@Override
	public void visit(Statement_doWhile statement_doWhile) {
		// Zaatvorimo sve 
		this.adresePopravkaAndUslova.pop();
		this.adresePopravkaOrUslova.pop();
		
		this.startDoWhileAdresePopravka.pop();
		
		this.adresePopravkaPocetkaDoWhileUslova.pop();
		this.adresePopravkaPocetkaNonDoWhileBloka.pop();
	}
	
	@Override
	public void visit(WhileUslov_bezCondition whileUslov_bezCondition) {
		
		// Ovde popravim one koji cekaju continue
		// Ovde moram da popravim sve continue
		for(int adresa: this.adresePopravkaPocetkaDoWhileUslova.peek()) {
			Code.fixup(adresa);
		}
		this.adresePopravkaPocetkaDoWhileUslova.peek().clear();
		
		// Bezuslovno skacem na pocetak while petlje
		Code.putJump(this.startDoWhileAdresePopravka.peek());
		
		// Popravimo ove sto cekaju break
		
		for(int adresa: this.adresePopravkaPocetkaNonDoWhileBloka.peek()) {
				Code.fixup(adresa);
			}
		 this.adresePopravkaPocetkaNonDoWhileBloka.peek().clear();
		
	}
	
	/* break */
	
	@Override
	public void visit(Statement_break statement_break) {
		
		Code.putJump(0);
		this.adresePopravkaPocetkaNonDoWhileBloka.peek().add(Code.pc - 2);
	}
	
	/* continue */
	
	@Override
	public void visit(Statement_continue statement_continue) {
		
		Code.putJump(0);
		this.adresePopravkaPocetkaDoWhileUslova.peek().add(Code.pc - 2);
	}
}

