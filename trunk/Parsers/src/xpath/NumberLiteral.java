package xpath;

import xpath.NumberExpression;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.40599C0C-72D7-8033-E5D1-6D660D1E81D7]
// </editor-fold> 
public class NumberLiteral extends NumberExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.359CC6FD-DC19-FBC8-1F3E-6D473814FB3D]
    // </editor-fold> 
    private float literal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2F8AE59-C780-2A71-D960-1A6CFEA8038A]
    // </editor-fold> 
    public NumberLiteral () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5D8028F2-AB34-07FB-D416-0295A936738D]
    // </editor-fold> 
    public float evaluate () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.EBB274D0-2BDD-D8AC-F3B8-62A9BD1B0175]
    // </editor-fold> 
    public float getLiteral () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.194994C5-91E9-7203-88B1-629C31DF3844]
    // </editor-fold> 
    public void setLiteral (float val) {
        this.literal = val;
    }

}

