// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class VarDecl_ok extends VarDecl {

    private TipVarijable TipVarijable;
    private ListaVarijabli ListaVarijabli;

    public VarDecl_ok (TipVarijable TipVarijable, ListaVarijabli ListaVarijabli) {
        this.TipVarijable=TipVarijable;
        if(TipVarijable!=null) TipVarijable.setParent(this);
        this.ListaVarijabli=ListaVarijabli;
        if(ListaVarijabli!=null) ListaVarijabli.setParent(this);
    }

    public TipVarijable getTipVarijable() {
        return TipVarijable;
    }

    public void setTipVarijable(TipVarijable TipVarijable) {
        this.TipVarijable=TipVarijable;
    }

    public ListaVarijabli getListaVarijabli() {
        return ListaVarijabli;
    }

    public void setListaVarijabli(ListaVarijabli ListaVarijabli) {
        this.ListaVarijabli=ListaVarijabli;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TipVarijable!=null) TipVarijable.accept(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TipVarijable!=null) TipVarijable.traverseTopDown(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TipVarijable!=null) TipVarijable.traverseBottomUp(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl_ok(\n");

        if(TipVarijable!=null)
            buffer.append(TipVarijable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListaVarijabli!=null)
            buffer.append(ListaVarijabli.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl_ok]");
        return buffer.toString();
    }
}
