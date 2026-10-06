// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodSignature MethodSignature;
    private FormParam FormParam;
    private ListaPromenljivihMetode ListaPromenljivihMetode;
    private StatementList StatementList;

    public MethodDecl (MethodSignature MethodSignature, FormParam FormParam, ListaPromenljivihMetode ListaPromenljivihMetode, StatementList StatementList) {
        this.MethodSignature=MethodSignature;
        if(MethodSignature!=null) MethodSignature.setParent(this);
        this.FormParam=FormParam;
        if(FormParam!=null) FormParam.setParent(this);
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodSignature getMethodSignature() {
        return MethodSignature;
    }

    public void setMethodSignature(MethodSignature MethodSignature) {
        this.MethodSignature=MethodSignature;
    }

    public FormParam getFormParam() {
        return FormParam;
    }

    public void setFormParam(FormParam FormParam) {
        this.FormParam=FormParam;
    }

    public ListaPromenljivihMetode getListaPromenljivihMetode() {
        return ListaPromenljivihMetode;
    }

    public void setListaPromenljivihMetode(ListaPromenljivihMetode ListaPromenljivihMetode) {
        this.ListaPromenljivihMetode=ListaPromenljivihMetode;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
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
        if(MethodSignature!=null) MethodSignature.accept(visitor);
        if(FormParam!=null) FormParam.accept(visitor);
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodSignature!=null) MethodSignature.traverseTopDown(visitor);
        if(FormParam!=null) FormParam.traverseTopDown(visitor);
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodSignature!=null) MethodSignature.traverseBottomUp(visitor);
        if(FormParam!=null) FormParam.traverseBottomUp(visitor);
        if(ListaPromenljivihMetode!=null) ListaPromenljivihMetode.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodSignature!=null)
            buffer.append(MethodSignature.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParam!=null)
            buffer.append(FormParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListaPromenljivihMetode!=null)
            buffer.append(ListaPromenljivihMetode.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
