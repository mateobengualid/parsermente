package xpath;

import xpath.BooleanExpression;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B3D3474A-9C7F-B368-10FF-0F5358A23EBA]
// </editor-fold> 
public class BooleanLiteral extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FD12D99D-667D-F267-3F0B-A6ED2FB02781]
    // </editor-fold> 
    private boolean literal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E083181F-F89B-996C-C762-65279C90DA88]
    // </editor-fold> 
    public BooleanLiteral () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B32C0C22-DE87-0960-822C-387CFDBF9DCF]
    // </editor-fold> 
    public boolean evaluate () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3D8EF09A-7750-6ABC-0FB8-FCE359948264]
    // </editor-fold> 
    public boolean getLiteral () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8FA8939A-B6E1-6A4A-941B-B4228074C9EA]
    // </editor-fold> 
    public void setLiteral (boolean val) {
        this.literal = val;
    }

}

