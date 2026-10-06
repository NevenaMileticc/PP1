// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Factor_pozivMetode extends Factor {

    private ImePozivaneMetode ImePozivaneMetode;
    private ActParsList ActParsList;

    public Factor_pozivMetode (ImePozivaneMetode ImePozivaneMetode, ActParsList ActParsList) {
        this.ImePozivaneMetode=ImePozivaneMetode;
        if(ImePozivaneMetode!=null) ImePozivaneMetode.setParent(this);
        this.ActParsList=ActParsList;
        if(ActParsList!=null) ActParsList.setParent(this);
    }

    public ImePozivaneMetode getImePozivaneMetode() {
        return ImePozivaneMetode;
    }

    public void setImePozivaneMetode(ImePozivaneMetode ImePozivaneMetode) {
        this.ImePozivaneMetode=ImePozivaneMetode;
    }

    public ActParsList getActParsList() {
        return ActParsList;
    }

    public void setActParsList(ActParsList ActParsList) {
        this.ActParsList=ActParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ImePozivaneMetode!=null) ImePozivaneMetode.accept(visitor);
        if(ActParsList!=null) ActParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ImePozivaneMetode!=null) ImePozivaneMetode.traverseTopDown(visitor);
        if(ActParsList!=null) ActParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ImePozivaneMetode!=null) ImePozivaneMetode.traverseBottomUp(visitor);
        if(ActParsList!=null) ActParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_pozivMetode(\n");

        if(ImePozivaneMetode!=null)
            buffer.append(ImePozivaneMetode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsList!=null)
            buffer.append(ActParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_pozivMetode]");
        return buffer.toString();
    }
}
