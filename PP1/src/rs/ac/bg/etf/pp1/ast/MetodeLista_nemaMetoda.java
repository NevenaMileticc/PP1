// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class MetodeLista_nemaMetoda extends MetodeLista {

    public MetodeLista_nemaMetoda () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MetodeLista_nemaMetoda(\n");

        buffer.append(tab);
        buffer.append(") [MetodeLista_nemaMetoda]");
        return buffer.toString();
    }
}
