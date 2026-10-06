// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaVarijabli_neposlednja extends ListaVarijabli {

    private Varijabla Varijabla;
    private ListaVarijabli ListaVarijabli;

    public ListaVarijabli_neposlednja (Varijabla Varijabla, ListaVarijabli ListaVarijabli) {
        this.Varijabla=Varijabla;
        if(Varijabla!=null) Varijabla.setParent(this);
        this.ListaVarijabli=ListaVarijabli;
        if(ListaVarijabli!=null) ListaVarijabli.setParent(this);
    }

    public Varijabla getVarijabla() {
        return Varijabla;
    }

    public void setVarijabla(Varijabla Varijabla) {
        this.Varijabla=Varijabla;
    }

    public ListaVarijabli getListaVarijabli() {
        return ListaVarijabli;
    }

    public void setListaVarijabli(ListaVarijabli ListaVarijabli) {
        this.ListaVarijabli=ListaVarijabli;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Varijabla!=null) Varijabla.accept(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Varijabla!=null) Varijabla.traverseTopDown(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Varijabla!=null) Varijabla.traverseBottomUp(visitor);
        if(ListaVarijabli!=null) ListaVarijabli.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaVarijabli_neposlednja(\n");

        if(Varijabla!=null)
            buffer.append(Varijabla.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ListaVarijabli!=null)
            buffer.append(ListaVarijabli.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaVarijabli_neposlednja]");
        return buffer.toString();
    }
}
