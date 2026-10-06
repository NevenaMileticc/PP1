// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class FormParam_imaParametre extends FormParam {

    private FormParamsList FormParamsList;

    public FormParam_imaParametre (FormParamsList FormParamsList) {
        this.FormParamsList=FormParamsList;
        if(FormParamsList!=null) FormParamsList.setParent(this);
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
        if(FormParamsList!=null) FormParamsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParamsList!=null) FormParamsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParamsList!=null) FormParamsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParam_imaParametre(\n");

        if(FormParamsList!=null)
            buffer.append(FormParamsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParam_imaParametre]");
        return buffer.toString();
    }
}
