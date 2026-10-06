// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class IfUslov_ok extends IfUslov {

    private PocetakIfUslova PocetakIfUslova;
    private Condition Condition;
    private KrajIfUslova KrajIfUslova;

    public IfUslov_ok (PocetakIfUslova PocetakIfUslova, Condition Condition, KrajIfUslova KrajIfUslova) {
        this.PocetakIfUslova=PocetakIfUslova;
        if(PocetakIfUslova!=null) PocetakIfUslova.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.KrajIfUslova=KrajIfUslova;
        if(KrajIfUslova!=null) KrajIfUslova.setParent(this);
    }

    public PocetakIfUslova getPocetakIfUslova() {
        return PocetakIfUslova;
    }

    public void setPocetakIfUslova(PocetakIfUslova PocetakIfUslova) {
        this.PocetakIfUslova=PocetakIfUslova;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public KrajIfUslova getKrajIfUslova() {
        return KrajIfUslova;
    }

    public void setKrajIfUslova(KrajIfUslova KrajIfUslova) {
        this.KrajIfUslova=KrajIfUslova;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PocetakIfUslova!=null) PocetakIfUslova.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(KrajIfUslova!=null) KrajIfUslova.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PocetakIfUslova!=null) PocetakIfUslova.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(KrajIfUslova!=null) KrajIfUslova.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PocetakIfUslova!=null) PocetakIfUslova.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(KrajIfUslova!=null) KrajIfUslova.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfUslov_ok(\n");

        if(PocetakIfUslova!=null)
            buffer.append(PocetakIfUslova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(KrajIfUslova!=null)
            buffer.append(KrajIfUslova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfUslov_ok]");
        return buffer.toString();
    }
}
