// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Varijabla_ok extends Varijabla {

    private String I1;
    private UglasteZagrade UglasteZagrade;

    public Varijabla_ok (String I1, UglasteZagrade UglasteZagrade) {
        this.I1=I1;
        this.UglasteZagrade=UglasteZagrade;
        if(UglasteZagrade!=null) UglasteZagrade.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public UglasteZagrade getUglasteZagrade() {
        return UglasteZagrade;
    }

    public void setUglasteZagrade(UglasteZagrade UglasteZagrade) {
        this.UglasteZagrade=UglasteZagrade;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(UglasteZagrade!=null) UglasteZagrade.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(UglasteZagrade!=null) UglasteZagrade.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(UglasteZagrade!=null) UglasteZagrade.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Varijabla_ok(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(UglasteZagrade!=null)
            buffer.append(UglasteZagrade.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Varijabla_ok]");
        return buffer.toString();
    }
}
