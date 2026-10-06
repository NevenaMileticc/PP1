// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:47


package rs.ac.bg.etf.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(Mulop Mulop) { }
    public void visit(FormParamsList FormParamsList) { }
    public void visit(Relop Relop) { }
    public void visit(MetodeLista MetodeLista) { }
    public void visit(FormParamDecl FormParamDecl) { }
    public void visit(StatementList StatementList) { }
    public void visit(FactorList FactorList) { }
    public void visit(Addop Addop) { }
    public void visit(Skup Skup) { }
    public void visit(Factor Factor) { }
    public void visit(CondTerm CondTerm) { }
    public void visit(KonstanteVarijableLista KonstanteVarijableLista) { }
    public void visit(Designator Designator) { }
    public void visit(ListaKonstanti ListaKonstanti) { }
    public void visit(TipMetode TipMetode) { }
    public void visit(Condition Condition) { }
    public void visit(PoslednjaVarijabla PoslednjaVarijabla) { }
    public void visit(ActParsList ActParsList) { }
    public void visit(ListaVarijabli ListaVarijabli) { }
    public void visit(Expr Expr) { }
    public void visit(AddopList AddopList) { }
    public void visit(ActPars ActPars) { }
    public void visit(ListaSkupova ListaSkupova) { }
    public void visit(DesignatorStatement DesignatorStatement) { }
    public void visit(IfUslov IfUslov) { }
    public void visit(BocniEfekat BocniEfekat) { }
    public void visit(Statement Statement) { }
    public void visit(VarDecl VarDecl) { }
    public void visit(CondFact CondFact) { }
    public void visit(Varijabla Varijabla) { }
    public void visit(UglasteZagrade UglasteZagrade) { }
    public void visit(PoslednjiSkup PoslednjiSkup) { }
    public void visit(SingleStatement SingleStatement) { }
    public void visit(WhileUslov WhileUslov) { }
    public void visit(ListaPromenljivihMetode ListaPromenljivihMetode) { }
    public void visit(VrednostKonstante VrednostKonstante) { }
    public void visit(FormParam FormParam) { }
    public void visit(Setop Setop) { visit(); }
    public void visit(Mulop_moduo Mulop_moduo) { visit(); }
    public void visit(Mulop_podeljeno Mulop_podeljeno) { visit(); }
    public void visit(Mulop_puta Mulop_puta) { visit(); }
    public void visit(Addop_minus Addop_minus) { visit(); }
    public void visit(Addop_plus Addop_plus) { visit(); }
    public void visit(Relop_veceJednako Relop_veceJednako) { visit(); }
    public void visit(Relop_manjeJednako Relop_manjeJednako) { visit(); }
    public void visit(Relop_vece Relop_vece) { visit(); }
    public void visit(Relop_manje Relop_manje) { visit(); }
    public void visit(Relop_razlicito Relop_razlicito) { visit(); }
    public void visit(Relop_jednakoJednako Relop_jednakoJednako) { visit(); }
    public void visit(Factor_expr Factor_expr) { visit(); }
    public void visit(Factor_newNiz Factor_newNiz) { visit(); }
    public void visit(Factor_newSkup Factor_newSkup) { visit(); }
    public void visit(Factor_bool Factor_bool) { visit(); }
    public void visit(Factor_char Factor_char) { visit(); }
    public void visit(Factor_int Factor_int) { visit(); }
    public void visit(Factor_designator Factor_designator) { visit(); }
    public void visit(Factor_pozivMetode Factor_pozivMetode) { visit(); }
    public void visit(FactorList_jedanFaktor FactorList_jedanFaktor) { visit(); }
    public void visit(FactorList_listaFaktora FactorList_listaFaktora) { visit(); }
    public void visit(Term Term) { visit(); }
    public void visit(AddopList_minus AddopList_minus) { visit(); }
    public void visit(AddopList_jedanTerm AddopList_jedanTerm) { visit(); }
    public void visit(AddopList_listaTermova AddopList_listaTermova) { visit(); }
    public void visit(Expr_map Expr_map) { visit(); }
    public void visit(Expr_lista Expr_lista) { visit(); }
    public void visit(ImeNizaDesignator ImeNizaDesignator) { visit(); }
    public void visit(Designator_ident Designator_ident) { visit(); }
    public void visit(Designator_niz Designator_niz) { visit(); }
    public void visit(ActParsList_prazna ActParsList_prazna) { visit(); }
    public void visit(ActParsList_neprazna ActParsList_neprazna) { visit(); }
    public void visit(ActPars_jedanIzraz ActPars_jedanIzraz) { visit(); }
    public void visit(ActPars_listaIzraza ActPars_listaIzraza) { visit(); }
    public void visit(ImePozivaneMetode ImePozivaneMetode) { visit(); }
    public void visit(DesignatorStatement_operacijaSaSkupovima DesignatorStatement_operacijaSaSkupovima) { visit(); }
    public void visit(DesignatorStatement_dekrement DesignatorStatement_dekrement) { visit(); }
    public void visit(DesignatorStatement_inkrement DesignatorStatement_inkrement) { visit(); }
    public void visit(DesignatorStatement_pozivMetode DesignatorStatement_pozivMetode) { visit(); }
    public void visit(DesignatorStatement_expr DesignatorStatement_expr) { visit(); }
    public void visit(CondFact_jedanIzraz CondFact_jedanIzraz) { visit(); }
    public void visit(CondFact_listaIzraza CondFact_listaIzraza) { visit(); }
    public void visit(CondTerm_jedanUslov CondTerm_jedanUslov) { visit(); }
    public void visit(CondTerm_listaAndUslova CondTerm_listaAndUslova) { visit(); }
    public void visit(KrajIliNaredbe KrajIliNaredbe) { visit(); }
    public void visit(Condition_jedanUslov Condition_jedanUslov) { visit(); }
    public void visit(Condition_listaOrUslova Condition_listaOrUslova) { visit(); }
    public void visit(IfUslov_error IfUslov_error) { visit(); }
    public void visit(IfUslov_ok IfUslov_ok) { visit(); }
    public void visit(BezBocnogEfekta BezBocnogEfekta) { visit(); }
    public void visit(SaBocnimEfektom SaBocnimEfektom) { visit(); }
    public void visit(WhileUslov_bezCondition WhileUslov_bezCondition) { visit(); }
    public void visit(WhileUslov_saCondition WhileUslov_saCondition) { visit(); }
    public void visit(Statement_read Statement_read) { visit(); }
    public void visit(Statement_printNumber Statement_printNumber) { visit(); }
    public void visit(Statement_print Statement_print) { visit(); }
    public void visit(Statement_returnExpr Statement_returnExpr) { visit(); }
    public void visit(Statement_return Statement_return) { visit(); }
    public void visit(Statement_continue Statement_continue) { visit(); }
    public void visit(Statement_break Statement_break) { visit(); }
    public void visit(Statement_doWhile Statement_doWhile) { visit(); }
    public void visit(Statement_ifElse Statement_ifElse) { visit(); }
    public void visit(Statement_if Statement_if) { visit(); }
    public void visit(Statement_designator Statement_designator) { visit(); }
    public void visit(Statement_block Statement_block) { visit(); }
    public void visit(Statement_single Statement_single) { visit(); }
    public void visit(StatementList_prazna StatementList_prazna) { visit(); }
    public void visit(StatementList_neprazna StatementList_neprazna) { visit(); }
    public void visit(PocetakElseBloka PocetakElseBloka) { visit(); }
    public void visit(KrajDoWhileUslova KrajDoWhileUslova) { visit(); }
    public void visit(PocetakDoWhileUslova PocetakDoWhileUslova) { visit(); }
    public void visit(KrajIfUslova KrajIfUslova) { visit(); }
    public void visit(PocetakIfUslova PocetakIfUslova) { visit(); }
    public void visit(PocetakDoWhileBloka PocetakDoWhileBloka) { visit(); }
    public void visit(PocetakIfBloka PocetakIfBloka) { visit(); }
    public void visit(FormParamDecl_Set FormParamDecl_Set) { visit(); }
    public void visit(FormParamDecl_nijeSet FormParamDecl_nijeSet) { visit(); }
    public void visit(FormParamsList_greska FormParamsList_greska) { visit(); }
    public void visit(FormParamsList_jedanParametar FormParamsList_jedanParametar) { visit(); }
    public void visit(FormParamsList_viseParametara FormParamsList_viseParametara) { visit(); }
    public void visit(FormParam_nemaParametre FormParam_nemaParametre) { visit(); }
    public void visit(FormParam_imaParametre FormParam_imaParametre) { visit(); }
    public void visit(TipMetode_void TipMetode_void) { visit(); }
    public void visit(TipMetode_pravi TipMetode_pravi) { visit(); }
    public void visit(MethodSignature MethodSignature) { visit(); }
    public void visit(ListaPromenljivihMetode_prazna ListaPromenljivihMetode_prazna) { visit(); }
    public void visit(ListaPromenljivihMetode_skup ListaPromenljivihMetode_skup) { visit(); }
    public void visit(ListaPromenljivihMetode_varijabla ListaPromenljivihMetode_varijabla) { visit(); }
    public void visit(MethodDecl MethodDecl) { visit(); }
    public void visit(MetodeLista_nemaMetoda MetodeLista_nemaMetoda) { visit(); }
    public void visit(MetodeLista_imaMetoda MetodeLista_imaMetoda) { visit(); }
    public void visit(PoslednjiSkup_error PoslednjiSkup_error) { visit(); }
    public void visit(PoslednjiSkup_ok PoslednjiSkup_ok) { visit(); }
    public void visit(Skup_error Skup_error) { visit(); }
    public void visit(Skup_ok Skup_ok) { visit(); }
    public void visit(ListaSkupova_poslednji ListaSkupova_poslednji) { visit(); }
    public void visit(ListaSkupova_neposlednji ListaSkupova_neposlednji) { visit(); }
    public void visit(SetDecl SetDecl) { visit(); }
    public void visit(PoslednjaVarijabla_error PoslednjaVarijabla_error) { visit(); }
    public void visit(PoslednjaVarijabla_ok PoslednjaVarijabla_ok) { visit(); }
    public void visit(VarijablaNijeNiz VarijablaNijeNiz) { visit(); }
    public void visit(VarijablaJeNiz VarijablaJeNiz) { visit(); }
    public void visit(Varijabla_error Varijabla_error) { visit(); }
    public void visit(Varijabla_ok Varijabla_ok) { visit(); }
    public void visit(ListaVarijabli_poslednja ListaVarijabli_poslednja) { visit(); }
    public void visit(ListaVarijabli_neposlednja ListaVarijabli_neposlednja) { visit(); }
    public void visit(TipVarijable TipVarijable) { visit(); }
    public void visit(VarDecl_error VarDecl_error) { visit(); }
    public void visit(VarDecl_ok VarDecl_ok) { visit(); }
    public void visit(Type Type) { visit(); }
    public void visit(ListaKonstanti_epsilon ListaKonstanti_epsilon) { visit(); }
    public void visit(ListaViseKonstanti ListaViseKonstanti) { visit(); }
    public void visit(VrednostKonstante_int VrednostKonstante_int) { visit(); }
    public void visit(VrednostKonstante_char VrednostKonstante_char) { visit(); }
    public void visit(VrednostKonstante_bool VrednostKonstante_bool) { visit(); }
    public void visit(TipKonstante TipKonstante) { visit(); }
    public void visit(ConstDecl ConstDecl) { visit(); }
    public void visit(KonstanteVarijableLista_epsilon KonstanteVarijableLista_epsilon) { visit(); }
    public void visit(KonstanteVarijableLista_skup KonstanteVarijableLista_skup) { visit(); }
    public void visit(KonstanteVarijableLista_konstanta KonstanteVarijableLista_konstanta) { visit(); }
    public void visit(KonstanteVarijableLista_varijabla KonstanteVarijableLista_varijabla) { visit(); }
    public void visit(ProgIme ProgIme) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
