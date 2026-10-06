// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaViseKonstanti extends ListaKonstanti {

    private ListaKonstanti ListaKonstanti;
    private VrednostKonstante VrednostKonstante;

    public ListaViseKonstanti (ListaKonstanti ListaKonstanti, VrednostKonstante VrednostKonstante) {
        this.ListaKonstanti=ListaKonstanti;
        if(ListaKonstanti!=null) ListaKonstanti.setParent(this);
        this.VrednostKonstante=VrednostKonstante;
        if(VrednostKonstante!=null) VrednostKonstante.setParent(this);
    }

    public ListaKonstanti getListaKonstanti() {
        return ListaKonstanti;
    }

    public void setListaKonstanti(ListaKonstanti ListaKonstanti) {
        this.ListaKonstanti=ListaKonstanti;
    }

    public VrednostKonstante getVrednostKonstante() {
        return VrednostKonstante;
    }

    public void setVrednostKonstante(VrednostKonstante VrednostKonstante) {
        this.VrednostKonstante=VrednostKonstante;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ListaKonstanti!=null) ListaKonstanti.accept(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ListaKonstanti!=null) ListaKonstanti.traverseTopDown(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ListaKonstanti!=null) ListaKonstanti.traverseBottomUp(visitor);
        if(VrednostKonstante!=null) VrednostKonstante.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaViseKonstanti(\n");

        if(ListaKonstanti!=null)
            buffer.append(ListaKonstanti.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VrednostKonstante!=null)
            buffer.append(VrednostKonstante.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaViseKonstanti]");
        return buffer.toString();
    }
}
