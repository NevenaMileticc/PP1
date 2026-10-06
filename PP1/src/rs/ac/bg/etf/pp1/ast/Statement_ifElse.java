// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Statement_ifElse extends SingleStatement {

    private IfUslov IfUslov;
    private PocetakIfBloka PocetakIfBloka;
    private Statement Statement;
    private PocetakElseBloka PocetakElseBloka;
    private Statement Statement1;

    public Statement_ifElse (IfUslov IfUslov, PocetakIfBloka PocetakIfBloka, Statement Statement, PocetakElseBloka PocetakElseBloka, Statement Statement1) {
        this.IfUslov=IfUslov;
        if(IfUslov!=null) IfUslov.setParent(this);
        this.PocetakIfBloka=PocetakIfBloka;
        if(PocetakIfBloka!=null) PocetakIfBloka.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.PocetakElseBloka=PocetakElseBloka;
        if(PocetakElseBloka!=null) PocetakElseBloka.setParent(this);
        this.Statement1=Statement1;
        if(Statement1!=null) Statement1.setParent(this);
    }

    public IfUslov getIfUslov() {
        return IfUslov;
    }

    public void setIfUslov(IfUslov IfUslov) {
        this.IfUslov=IfUslov;
    }

    public PocetakIfBloka getPocetakIfBloka() {
        return PocetakIfBloka;
    }

    public void setPocetakIfBloka(PocetakIfBloka PocetakIfBloka) {
        this.PocetakIfBloka=PocetakIfBloka;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public PocetakElseBloka getPocetakElseBloka() {
        return PocetakElseBloka;
    }

    public void setPocetakElseBloka(PocetakElseBloka PocetakElseBloka) {
        this.PocetakElseBloka=PocetakElseBloka;
    }

    public Statement getStatement1() {
        return Statement1;
    }

    public void setStatement1(Statement Statement1) {
        this.Statement1=Statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfUslov!=null) IfUslov.accept(visitor);
        if(PocetakIfBloka!=null) PocetakIfBloka.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(PocetakElseBloka!=null) PocetakElseBloka.accept(visitor);
        if(Statement1!=null) Statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfUslov!=null) IfUslov.traverseTopDown(visitor);
        if(PocetakIfBloka!=null) PocetakIfBloka.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(PocetakElseBloka!=null) PocetakElseBloka.traverseTopDown(visitor);
        if(Statement1!=null) Statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfUslov!=null) IfUslov.traverseBottomUp(visitor);
        if(PocetakIfBloka!=null) PocetakIfBloka.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(PocetakElseBloka!=null) PocetakElseBloka.traverseBottomUp(visitor);
        if(Statement1!=null) Statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_ifElse(\n");

        if(IfUslov!=null)
            buffer.append(IfUslov.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PocetakIfBloka!=null)
            buffer.append(PocetakIfBloka.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PocetakElseBloka!=null)
            buffer.append(PocetakElseBloka.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement1!=null)
            buffer.append(Statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_ifElse]");
        return buffer.toString();
    }
}
