// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TipKonstante TipKonstante;
    private VrednostKonstante VrednostKonstante;
    private ListaKonstanti ListaKonstanti;

    public ConstDecl (TipKonstante TipKonstante, VrednostKonstante VrednostKonstante, ListaKonstanti ListaKonstanti) {
        this.TipKonstante=TipKonstante;
        if(TipKonstante!=null) TipKonstante.setParent(this);
        this.VrednostKonstante=VrednostKonstante;
        if(VrednostKonstante!=null) VrednostKonstante.setParent(this);
        this.ListaKonstanti=ListaKonstanti;
        if(ListaKonstanti!=null) ListaKonstanti.setParent(this);
    }

    public TipKonstante getTipKonstante() {
        return TipKonstante;
    }

    public void setTipKonstante(TipKonstante TipKonstante) {
        this.TipKonstante=TipKonstante;
    }

    public VrednostKonstante getVrednostKonstante() {
        return VrednostKonstante;
    }

    public void setVrednostKonstante(VrednostKonstante VrednostKonstante) {
        this.VrednostKonstante=VrednostKonstante;
    }

    public ListaKonstanti getListaKonstanti() {
        return ListaKonstanti;
    }

    public void setListaKonstanti(ListaKonstanti ListaKonstanti) {
        this.ListaKonstanti=ListaKonstanti;
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
        if(TipKonstante!=null) TipKonstante.accept(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.accept(visitor);
        if(ListaKonstanti!=null) ListaKonstanti.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TipKonstante!=null) TipKonstante.traverseTopDown(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.traverseTopDown(visitor);
        if(ListaKonstanti!=null) ListaKonstanti.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TipKonstante!=null) TipKonstante.traverseBottomUp(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.traverseBottomUp(visitor);
        if(ListaKonstanti!=null) ListaKonstanti.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(TipKonstante!=null)
            buffer.append(TipKonstante.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VrednostKonstante!=null)
            buffer.append(VrednostKonstante.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListaKonstanti!=null)
            buffer.append(ListaKonstanti.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
