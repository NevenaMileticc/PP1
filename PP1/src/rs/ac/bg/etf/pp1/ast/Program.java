// generated with ast extension for cup
// version 0.8
// 30/11/2024 14:0:46


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgIme ProgIme;
    private KonstanteVarijableLista KonstanteVarijableLista;
    private MetodeLista MetodeLista;

    public Program (ProgIme ProgIme, KonstanteVarijableLista KonstanteVarijableLista, MetodeLista MetodeLista) {
        this.ProgIme=ProgIme;
        if(ProgIme!=null) ProgIme.setParent(this);
        this.KonstanteVarijableLista=KonstanteVarijableLista;
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.setParent(this);
        this.MetodeLista=MetodeLista;
        if(MetodeLista!=null) MetodeLista.setParent(this);
    }

    public ProgIme getProgIme() {
        return ProgIme;
    }

    public void setProgIme(ProgIme ProgIme) {
        this.ProgIme=ProgIme;
    }

    public KonstanteVarijableLista getKonstanteVarijableLista() {
        return KonstanteVarijableLista;
    }

    public void setKonstanteVarijableLista(KonstanteVarijableLista KonstanteVarijableLista) {
        this.KonstanteVarijableLista=KonstanteVarijableLista;
    }

    public MetodeLista getMetodeLista() {
        return MetodeLista;
    }

    public void setMetodeLista(MetodeLista MetodeLista) {
        this.MetodeLista=MetodeLista;
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
        if(ProgIme!=null) ProgIme.accept(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.accept(visitor);
        if(MetodeLista!=null) MetodeLista.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgIme!=null) ProgIme.traverseTopDown(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseTopDown(visitor);
        if(MetodeLista!=null) MetodeLista.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgIme!=null) ProgIme.traverseBottomUp(visitor);
        if(KonstanteVarijableLista!=null) KonstanteVarijableLista.traverseBottomUp(visitor);
        if(MetodeLista!=null) MetodeLista.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgIme!=null)
            buffer.append(ProgIme.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(KonstanteVarijableLista!=null)
            buffer.append(KonstanteVarijableLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MetodeLista!=null)
            buffer.append(MetodeLista.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
