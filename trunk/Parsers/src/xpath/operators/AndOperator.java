package xpath.operators;

import xpath.BooleanExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.57CAEFD4-3A28-96E8-1751-BB4973781452]
// </editor-fold> 
public class AndOperator extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F6C4297C-8BF3-F02B-9BBE-37F91DE29AFC]
    // </editor-fold> 
    public AndOperator () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F23A9D1C-7EC0-1F2E-B8AE-0019BDADE021]
    // </editor-fold> 
    public boolean evaluate () {
        BooleanExpression firstArgument = (BooleanExpression) arguments.get(0);
        BooleanExpression secondArgument = (BooleanExpression) arguments.get(1);
        
        return firstArgument.evaluate() && secondArgument.evaluate();
    }

}

