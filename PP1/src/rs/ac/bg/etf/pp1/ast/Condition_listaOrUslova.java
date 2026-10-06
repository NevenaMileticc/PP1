// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Condition_listaOrUslova extends Condition {

    private Condition Condition;
    private KrajIliNaredbe KrajIliNaredbe;
    private CondTerm CondTerm;

    public Condition_listaOrUslova (Condition Condition, KrajIliNaredbe KrajIliNaredbe, CondTerm CondTerm) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.KrajIliNaredbe=KrajIliNaredbe;
        if(KrajIliNaredbe!=null) KrajIliNaredbe.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public KrajIliNaredbe getKrajIliNaredbe() {
        return KrajIliNaredbe;
    }

    public void setKrajIliNaredbe(KrajIliNaredbe KrajIliNaredbe) {
        this.KrajIliNaredbe=KrajIliNaredbe;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(KrajIliNaredbe!=null) KrajIliNaredbe.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(KrajIliNaredbe!=null) KrajIliNaredbe.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(KrajIliNaredbe!=null) KrajIliNaredbe.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Condition_listaOrUslova(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(KrajIliNaredbe!=null)
            buffer.append(KrajIliNaredbe.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Condition_listaOrUslova]");
        return buffer.toString();
    }
}
