package xpath.functions;

import xpath.BooleanExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0FA90E56-B0C3-76A4-60F3-895AC1C0B275]
// </editor-fold> 
public class NotFunction extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A396BED1-AA92-009E-4905-2EB8F79ECEAF]
    // </editor-fold> 
    public NotFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5954FB51-09A1-261A-7113-E91D4A5B1DA0]
    // </editor-fold> 
    public boolean evaluate () {
        return !((BooleanExpression)arguments.get(0)).evaluate();
    }

}

