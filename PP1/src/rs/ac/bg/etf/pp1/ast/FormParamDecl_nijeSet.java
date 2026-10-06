// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class FormParamDecl_nijeSet extends FormParamDecl {

    private Type Type;
    private String I2;
    private UglasteZagrade UglasteZagrade;

    public FormParamDecl_nijeSet (Type Type, String I2, UglasteZagrade UglasteZagrade) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.UglasteZagrade=UglasteZagrade;
        if(UglasteZagrade!=null) UglasteZagrade.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public UglasteZagrade getUglasteZagrade() {
        return UglasteZagrade;
    }

    public void setUglasteZagrade(UglasteZagrade UglasteZagrade) {
        this.UglasteZagrade=UglasteZagrade;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(UglasteZagrade!=null) UglasteZagrade.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(UglasteZagrade!=null) UglasteZagrade.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(UglasteZagrade!=null) UglasteZagrade.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamDecl_nijeSet(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(UglasteZagrade!=null)
            buffer.append(UglasteZagrade.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamDecl_nijeSet]");
        return buffer.toString();
    }
}
