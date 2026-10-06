// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class MetodeLista_imaMetoda extends MetodeLista {

    private MetodeLista MetodeLista;
    private MethodDecl MethodDecl;

    public MetodeLista_imaMetoda (MetodeLista MetodeLista, MethodDecl MethodDecl) {
        this.MetodeLista=MetodeLista;
        if(MetodeLista!=null) MetodeLista.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public MetodeLista getMetodeLista() {
        return MetodeLista;
    }

    public void setMetodeLista(MetodeLista MetodeLista) {
        this.MetodeLista=MetodeLista;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MetodeLista!=null) MetodeLista.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MetodeLista!=null) MetodeLista.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MetodeLista!=null) MetodeLista.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MetodeLista_imaMetoda(\n");

        if(MetodeLista!=null)
            buffer.append(MetodeLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MetodeLista_imaMetoda]");
        return buffer.toString();
    }
}
