// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class ListaSkupova_poslednji extends ListaSkupova {

    private PoslednjiSkup PoslednjiSkup;

    public ListaSkupova_poslednji (PoslednjiSkup PoslednjiSkup) {
        this.PoslednjiSkup=PoslednjiSkup;
        if(PoslednjiSkup!=null) PoslednjiSkup.setParent(this);
    }

    public PoslednjiSkup getPoslednjiSkup() {
        return PoslednjiSkup;
    }

    public void setPoslednjiSkup(PoslednjiSkup PoslednjiSkup) {
        this.PoslednjiSkup=PoslednjiSkup;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PoslednjiSkup!=null) PoslednjiSkup.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PoslednjiSkup!=null) PoslednjiSkup.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PoslednjiSkup!=null) PoslednjiSkup.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListaSkupova_poslednji(\n");

        if(PoslednjiSkup!=null)
            buffer.append(PoslednjiSkup.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListaSkupova_poslednji]");
        return buffer.toString();
    }
}
