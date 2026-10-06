// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Designator_niz extends Designator {

    private ImeNizaDesignator ImeNizaDesignator;
    private Expr Expr;

    public Designator_niz (ImeNizaDesignator ImeNizaDesignator, Expr Expr) {
        this.ImeNizaDesignator=ImeNizaDesignator;
        if(ImeNizaDesignator!=null) ImeNizaDesignator.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ImeNizaDesignator getImeNizaDesignator() {
        return ImeNizaDesignator;
    }

    public void setImeNizaDesignator(ImeNizaDesignator ImeNizaDesignator) {
        this.ImeNizaDesignator=ImeNizaDesignator;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ImeNizaDesignator!=null) ImeNizaDesignator.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ImeNizaDesignator!=null) ImeNizaDesignator.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ImeNizaDesignator!=null) ImeNizaDesignator.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_niz(\n");

        if(ImeNizaDesignator!=null)
            buffer.append(ImeNizaDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_niz]");
        return buffer.toString();
    }
}
