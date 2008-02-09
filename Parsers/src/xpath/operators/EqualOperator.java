package xpath.operators;

import xpath.BooleanExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// </editor-fold> 
public class EqualOperator extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4CA6E09F-F35C-5465-334D-47868960ACCD]
    // </editor-fold> 
    public EqualOperator () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A5CFA508-F136-71B4-5745-EB23D2C744F7]
    // </editor-fold> 
    public boolean evaluate () {
        BooleanExpression firstArgument = (BooleanExpression) arguments.get(0);
        BooleanExpression secondArgument = (BooleanExpression) arguments.get(1);
        
        // TODO Esto esta incompleto, agrandarlo
        return firstArgument.evaluate() == secondArgument.evaluate();
    }

}

