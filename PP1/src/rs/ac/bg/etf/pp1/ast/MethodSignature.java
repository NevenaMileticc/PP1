// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class MethodSignature implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private TipMetode TipMetode;
    private String I2;

    public MethodSignature (TipMetode TipMetode, String I2) {
        this.TipMetode=TipMetode;
        if(TipMetode!=null) TipMetode.setParent(this);
        this.I2=I2;
    }

    public TipMetode getTipMetode() {
        return TipMetode;
    }

    public void setTipMetode(TipMetode TipMetode) {
        this.TipMetode=TipMetode;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(TipMetode!=null) TipMetode.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TipMetode!=null) TipMetode.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TipMetode!=null) TipMetode.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodSignature(\n");

        if(TipMetode!=null)
            buffer.append(TipMetode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodSignature]");
        return buffer.toString();
    }
}
