// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class WhileUslov_saCondition extends WhileUslov {

    private PocetakDoWhileUslova PocetakDoWhileUslova;
    private Condition Condition;
    private KrajDoWhileUslova KrajDoWhileUslova;
    private BocniEfekat BocniEfekat;

    public WhileUslov_saCondition (PocetakDoWhileUslova PocetakDoWhileUslova, Condition Condition, KrajDoWhileUslova KrajDoWhileUslova, BocniEfekat BocniEfekat) {
        this.PocetakDoWhileUslova=PocetakDoWhileUslova;
        if(PocetakDoWhileUslova!=null) PocetakDoWhileUslova.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.KrajDoWhileUslova=KrajDoWhileUslova;
        if(KrajDoWhileUslova!=null) KrajDoWhileUslova.setParent(this);
        this.BocniEfekat=BocniEfekat;
        if(BocniEfekat!=null) BocniEfekat.setParent(this);
    }

    public PocetakDoWhileUslova getPocetakDoWhileUslova() {
        return PocetakDoWhileUslova;
    }

    public void setPocetakDoWhileUslova(PocetakDoWhileUslova PocetakDoWhileUslova) {
        this.PocetakDoWhileUslova=PocetakDoWhileUslova;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public KrajDoWhileUslova getKrajDoWhileUslova() {
        return KrajDoWhileUslova;
    }

    public void setKrajDoWhileUslova(KrajDoWhileUslova KrajDoWhileUslova) {
        this.KrajDoWhileUslova=KrajDoWhileUslova;
    }

    public BocniEfekat getBocniEfekat() {
        return BocniEfekat;
    }

    public void setBocniEfekat(BocniEfekat BocniEfekat) {
        this.BocniEfekat=BocniEfekat;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PocetakDoWhileUslova!=null) PocetakDoWhileUslova.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(KrajDoWhileUslova!=null) KrajDoWhileUslova.accept(visitor);
        if(BocniEfekat!=null) BocniEfekat.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PocetakDoWhileUslova!=null) PocetakDoWhileUslova.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(KrajDoWhileUslova!=null) KrajDoWhileUslova.traverseTopDown(visitor);
        if(BocniEfekat!=null) BocniEfekat.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PocetakDoWhileUslova!=null) PocetakDoWhileUslova.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(KrajDoWhileUslova!=null) KrajDoWhileUslova.traverseBottomUp(visitor);
        if(BocniEfekat!=null) BocniEfekat.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WhileUslov_saCondition(\n");

        if(PocetakDoWhileUslova!=null)
            buffer.append(PocetakDoWhileUslova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(KrajDoWhileUslova!=null)
            buffer.append(KrajDoWhileUslova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BocniEfekat!=null)
            buffer.append(BocniEfekat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WhileUslov_saCondition]");
        return buffer.toString();
    }
}
