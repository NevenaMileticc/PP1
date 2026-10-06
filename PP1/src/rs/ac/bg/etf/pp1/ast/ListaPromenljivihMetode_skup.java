// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaPromenljivihMetode_skup extends ListaPromenljivihMetode {

    private ListaPromenljivihMetode ListaPromenljivihMetode;
    private SetDecl SetDecl;

    public ListaPromenljivihMetode_skup (ListaPromenljivihMetode ListaPromenljivihMetode, SetDecl SetDecl) {
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.setParent(this);
        this.SetDecl=SetDecl;
        if(SetDecl!=null) SetDecl.setParent(this);
    }

    public ListaPromenljivihMetode getListaPromenljivihMetode() {
        return ListaPromenljivihMetode;
    }

    public void setListaPromenljivihMetode(ListaPromenljivihMetode ListaPromenljivihMetode) {
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
    }

    public SetDecl getSetDecl() {
        return SetDecl;
    }

    public void setSetDecl(SetDecl SetDecl) {
        this.SetDecl=SetDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.accept(visitor);
        if(SetDecl!=null) SetDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseTopDown(visitor);
        if(SetDecl!=null) SetDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseBottomUp(visitor);
        if(SetDecl!=null) SetDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaPromenljivihMetode_skup(\n");

        if(ListaPromenljivihMetode!=null)
            buffer.append(ListaPromenljivihMetode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SetDecl!=null)
            buffer.append(SetDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaPromenljivihMetode_skup]");
        return buffer.toString();
    }
}
