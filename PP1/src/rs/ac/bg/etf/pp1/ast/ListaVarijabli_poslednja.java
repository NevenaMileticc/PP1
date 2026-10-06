// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaVarijabli_poslednja extends ListaVarijabli {

    private PoslednjaVarijabla PoslednjaVarijabla;

    public ListaVarijabli_poslednja (PoslednjaVarijabla PoslednjaVarijabla) {
        this.PoslednjaVarijabla=PoslednjaVarijabla;
        if(PoslednjaVarijabla!=null) PoslednjaVarijabla.setParent(this);
    }

    public PoslednjaVarijabla getPoslednjaVarijabla() {
        return PoslednjaVarijabla;
    }

    public void setPoslednjaVarijabla(PoslednjaVarijabla PoslednjaVarijabla) {
        this.PoslednjaVarijabla=PoslednjaVarijabla;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PoslednjaVarijabla!=null) PoslednjaVarijabla.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PoslednjaVarijabla!=null) PoslednjaVarijabla.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PoslednjaVarijabla!=null) PoslednjaVarijabla.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaVarijabli_poslednja(\n");

        if(PoslednjaVarijabla!=null)
            buffer.append(PoslednjaVarijabla.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaVarijabli_poslednja]");
        return buffer.toString();
    }
}
