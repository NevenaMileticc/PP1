// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaSkupova_neposlednji extends ListaSkupova {

    private Skup Skup;
    private ListaSkupova ListaSkupova;

    public ListaSkupova_neposlednji (Skup Skup, ListaSkupova ListaSkupova) {
        this.Skup=Skup;
        if(Skup!=null) Skup.setParent(this);
        this.ListaSkupova=ListaSkupova;
        if(ListaSkupova!=null) ListaSkupova.setParent(this);
    }

    public Skup getSkup() {
        return Skup;
    }

    public void setSkup(Skup Skup) {
        this.Skup=Skup;
    }

    public ListaSkupova getListaSkupova() {
        return ListaSkupova;
    }

    public void setListaSkupova(ListaSkupova ListaSkupova) {
        this.ListaSkupova=ListaSkupova;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Skup!=null) Skup.accept(visitor);
        if(ListaSkupova!=null) ListaSkupova.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Skup!=null) Skup.traverseTopDown(visitor);
        if(ListaSkupova!=null) ListaSkupova.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Skup!=null) Skup.traverseBottomUp(visitor);
        if(ListaSkupova!=null) ListaSkupova.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaSkupova_neposlednji(\n");

        if(Skup!=null)
            buffer.append(Skup.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListaSkupova!=null)
            buffer.append(ListaSkupova.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaSkupova_neposlednji]");
        return buffer.toString();
    }
}
