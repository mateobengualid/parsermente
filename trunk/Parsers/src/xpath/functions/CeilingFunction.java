package xpath.functions;

import xpath.NumberExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C7A24926-85C1-2430-4551-47A27C85181C]
// </editor-fold> 
public class CeilingFunction extends NumberExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0C5FD5EB-084B-26D9-E58A-D4D0B64DC4FC]
    // </editor-fold> 
    public CeilingFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D334BD7A-2948-693C-0AAC-B8BAAA2F6B85]
    // </editor-fold> 
    public float evaluate () {
        float firstArgument = ((NumberExpression)arguments.get(0)).evaluate();
        
        return (float) Math.ceil(firstArgument);
    }

}

