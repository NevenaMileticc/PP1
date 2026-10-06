// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class SetDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ListaSkupova ListaSkupova;

    public SetDecl (ListaSkupova ListaSkupova) {
        this.ListaSkupova=ListaSkupova;
        if(ListaSkupova!=null) ListaSkupova.setParent(this);
    }

    public ListaSkupova getListaSkupova() {
        return ListaSkupova;
    }

    public void setListaSkupova(ListaSkupova ListaSkupova) {
        this.ListaSkupova=ListaSkupova;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListaSkupova!=null) ListaSkupova.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListaSkupova!=null) ListaSkupova.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListaSkupova!=null) ListaSkupova.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SetDecl(\n");

        if(ListaSkupova!=null)
            buffer.append(ListaSkupova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SetDecl]");
        return buffer.toString();
    }
}
