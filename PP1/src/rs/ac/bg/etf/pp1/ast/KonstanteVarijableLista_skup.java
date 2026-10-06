// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class KonstanteVarijableLista_skup extends KonstanteVarijableLista {

    private KonstanteVarijableLista KonstanteVarijableLista;
    private SetDecl SetDecl;

    public KonstanteVarijableLista_skup (KonstanteVarijableLista KonstanteVarijableLista, SetDecl SetDecl) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.setParent(this);
        this.SetDecl=SetDecl;
        if(SetDecl!=null) SetDecl.setParent(this);
    }

    public KonstanteVarijableLista getKonstanteVarijableLista() {
        return KonstanteVarijableLista;
    }

    public void setKonstanteVarijableLista(KonstanteVarijableLista KonstanteVarijableLista) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
    }

    public SetDecl getSetDecl() {
        return SetDecl;
    }

    public void setSetDecl(SetDecl SetDecl) {
        this.SetDecl=SetDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.accept(visitor);
        if(SetDecl!=null) SetDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseTopDown(visitor);
        if(SetDecl!=null) SetDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseBottomUp(visitor);
        if(SetDecl!=null) SetDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("KonstanteVarijableLista_skup(\n");

        if(KonstanteVarijableLista!=null)
            buffer.append(KonstanteVarijableLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SetDecl!=null)
            buffer.append(SetDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [KonstanteVarijableLista_skup]");
        return buffer.toString();
    }
}
