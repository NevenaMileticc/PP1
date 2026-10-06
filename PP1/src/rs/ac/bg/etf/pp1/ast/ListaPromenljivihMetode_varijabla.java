// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaPromenljivihMetode_varijabla extends ListaPromenljivihMetode {

    private ListaPromenljivihMetode ListaPromenljivihMetode;
    private VarDecl VarDecl;

    public ListaPromenljivihMetode_varijabla (ListaPromenljivihMetode ListaPromenljivihMetode, VarDecl VarDecl) {
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public ListaPromenljivihMetode getListaPromenljivihMetode() {
        return ListaPromenljivihMetode;
    }

    public void setListaPromenljivihMetode(ListaPromenljivihMetode ListaPromenljivihMetode) {
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaPromenljivihMetode_varijabla(\n");

        if(ListaPromenljivihMetode!=null)
            buffer.append(ListaPromenljivihMetode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaPromenljivihMetode_varijabla]");
        return buffer.toString();
    }
}
