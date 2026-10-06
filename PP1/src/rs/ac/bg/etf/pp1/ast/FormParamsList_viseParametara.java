// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class FormParamsList_viseParametara extends FormParamsList {

    private FormParamDecl FormParamDecl;
    private FormParamsList FormParamsList;

    public FormParamsList_viseParametara (FormParamDecl FormParamDecl, FormParamsList FormParamsList) {
        this.FormParamDecl=FormParamDecl;
        if(FormParamDecl!=null) FormParamDecl.setParent(this);
        this.FormParamsList=FormParamsList;
        if(FormParamsList!=null) FormParamsList.setParent(this);
    }

    public FormParamDecl getFormParamDecl() {
        return FormParamDecl;
    }

    public void setFormParamDecl(FormParamDecl FormParamDecl) {
        this.FormParamDecl=FormParamDecl;
    }

    public FormParamsList getFormParamsList() {
        return FormParamsList;
    }

    public void setFormParamsList(FormParamsList FormParamsList) {
        this.FormParamsList=FormParamsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParamDecl!=null) FormParamDecl.accept(visitor);
        if(FormParamsList!=null) FormParamsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParamDecl!=null) FormParamDecl.traverseTopDown(visitor);
        if(FormParamsList!=null) FormParamsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParamDecl!=null) FormParamDecl.traverseBottomUp(visitor);
        if(FormParamsList!=null) FormParamsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamsList_viseParametara(\n");

        if(FormParamDecl!=null)
            buffer.append(FormParamDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamsList!=null)
            buffer.append(FormParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamsList_viseParametara]");
        return buffer.toString();
    }
}
