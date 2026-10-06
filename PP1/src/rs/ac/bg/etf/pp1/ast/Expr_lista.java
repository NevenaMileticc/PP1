// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Expr_lista extends Expr {

    private AddopList AddopList;

    public Expr_lista (AddopList AddopList) {
        this.AddopList=AddopList;
        if(AddopList!=null) AddopList.setParent(this);
    }

    public AddopList getAddopList() {
        return AddopList;
    }

    public void setAddopList(AddopList AddopList) {
        this.AddopList=AddopList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopList!=null) AddopList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopList!=null) AddopList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopList!=null) AddopList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr_lista(\n");

        if(AddopList!=null)
            buffer.append(AddopList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr_lista]");
        return buffer.toString();
    }
}
