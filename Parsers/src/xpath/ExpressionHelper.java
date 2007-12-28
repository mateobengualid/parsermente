package xpath;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.9843A8AA-F5A0-C50E-6625-B80B6236CC7A]
// </editor-fold> 
public abstract class ExpressionHelper {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F29A5107-8EF6-A20C-48C0-4C9214A3E1BE]
    // </editor-fold> 
    protected Expression expression;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.96B35898-E45C-0BE3-DBEE-00780E0773D9]
    // </editor-fold> 
    public abstract void parseExpression ();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CF2BEBE5-7EDC-F4B3-3C42-A5AF6960AA53]
    // </editor-fold> 
    public Expression getExpression () {
        return expression;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.178CA2AA-9B63-BF7F-1FFF-016D251F03DE]
    // </editor-fold> 
    public void setExpression (Expression val) {
        this.expression = val;
    }

}

