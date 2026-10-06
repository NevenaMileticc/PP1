// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class KonstanteVarijableLista_varijabla extends KonstanteVarijableLista {

    private KonstanteVarijableLista KonstanteVarijableLista;
    private VarDecl VarDecl;

    public KonstanteVarijableLista_varijabla (KonstanteVarijableLista KonstanteVarijableLista, VarDecl VarDecl) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public KonstanteVarijableLista getKonstanteVarijableLista() {
        return KonstanteVarijableLista;
    }

    public void setKonstanteVarijableLista(KonstanteVarijableLista KonstanteVarijableLista) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("KonstanteVarijableLista_varijabla(\n");

        if(KonstanteVarijableLista!=null)
            buffer.append(KonstanteVarijableLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [KonstanteVarijableLista_varijabla]");
        return buffer.toString();
    }
}
