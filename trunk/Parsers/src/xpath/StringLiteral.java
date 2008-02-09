package xpath;

import xpath.StringExpression;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C1EA0EA9-0680-5259-8F4D-216343BC4DA4]
// </editor-fold> 
public class StringLiteral extends StringExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3B4AE721-0505-B51A-61C5-52558F40F528]
    // </editor-fold> 
    private String literal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA16F386-BD2C-25E3-324D-3A4C16F271E8]
    // </editor-fold> 
    public StringLiteral () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A0B05AB8-13BD-B6F4-A9E7-0878305EE0C2]
    // </editor-fold> 
    public String evaluate () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B7C2876B-A1CA-45F1-951F-689290ABB7C6]
    // </editor-fold> 
    public String getLiteral () {
        return literal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5808662C-7EA8-EBC2-B502-4B27DAB0F025]
    // </editor-fold> 
    public void setLiteral (String val) {
        this.literal = val;
    }

}

