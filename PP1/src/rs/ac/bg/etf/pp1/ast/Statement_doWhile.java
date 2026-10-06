// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Statement_doWhile extends SingleStatement {

    private PocetakDoWhileBloka PocetakDoWhileBloka;
    private Statement Statement;
    private WhileUslov WhileUslov;

    public Statement_doWhile (PocetakDoWhileBloka PocetakDoWhileBloka, Statement Statement, WhileUslov WhileUslov) {
        this.PocetakDoWhileBloka=PocetakDoWhileBloka;
        if(PocetakDoWhileBloka!=null) PocetakDoWhileBloka.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.WhileUslov=WhileUslov;
        if(WhileUslov!=null) WhileUslov.setParent(this);
    }

    public PocetakDoWhileBloka getPocetakDoWhileBloka() {
        return PocetakDoWhileBloka;
    }

    public void setPocetakDoWhileBloka(PocetakDoWhileBloka PocetakDoWhileBloka) {
        this.PocetakDoWhileBloka=PocetakDoWhileBloka;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public WhileUslov getWhileUslov() {
        return WhileUslov;
    }

    public void setWhileUslov(WhileUslov WhileUslov) {
        this.WhileUslov=WhileUslov;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PocetakDoWhileBloka!=null) PocetakDoWhileBloka.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(WhileUslov!=null) WhileUslov.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PocetakDoWhileBloka!=null) PocetakDoWhileBloka.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(WhileUslov!=null) WhileUslov.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PocetakDoWhileBloka!=null) PocetakDoWhileBloka.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(WhileUslov!=null) WhileUslov.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_doWhile(\n");

        if(PocetakDoWhileBloka!=null)
            buffer.append(PocetakDoWhileBloka.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileUslov!=null)
            buffer.append(WhileUslov.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_doWhile]");
        return buffer.toString();
    }
}
