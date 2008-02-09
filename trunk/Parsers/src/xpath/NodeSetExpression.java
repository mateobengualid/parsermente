package xpath;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.6DA87DA3-AC15-69EC-932F-2E239C6F01ED]
// </editor-fold> 
public abstract class NodeSetExpression extends Expression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6E4FAA6C-DD37-A8FE-E845-8C2B327FD1F5]
    // </editor-fold> 
    public NodeSetExpression () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D76FDAA1-11F9-58B5-8865-435778266AAA]
    // </editor-fold> 
    public abstract NodeSet evaluate ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5B91DBEA-6D00-65CC-D40F-86C2E5B3E782]
    // </editor-fold> 
    public boolean isEmpty () {
        return true;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.928E8581-C45F-CE38-8C36-EB3FB4782506]
    // </editor-fold> 
    public int length () {
        return 0;
    }

}

