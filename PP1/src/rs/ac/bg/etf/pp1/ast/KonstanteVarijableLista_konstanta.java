// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class KonstanteVarijableLista_konstanta extends KonstanteVarijableLista {

    private KonstanteVarijableLista KonstanteVarijableLista;
    private ConstDecl ConstDecl;

    public KonstanteVarijableLista_konstanta (KonstanteVarijableLista KonstanteVarijableLista, ConstDecl ConstDecl) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public KonstanteVarijableLista getKonstanteVarijableLista() {
        return KonstanteVarijableLista;
    }

    public void setKonstanteVarijableLista(KonstanteVarijableLista KonstanteVarijableLista) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("KonstanteVarijableLista_konstanta(\n");

        if(KonstanteVarijableLista!=null)
            buffer.append(KonstanteVarijableLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [KonstanteVarijableLista_konstanta]");
        return buffer.toString();
    }
}
