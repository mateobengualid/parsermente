package xpath.operators;

import xpath.BooleanExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8222E1BB-5E4B-B8ED-E763-B125E68887F5]
// </editor-fold> 
public class OrOperator extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F3D735A3-C708-1C3B-9051-BE1F04A9C0B9]
    // </editor-fold> 
    public OrOperator () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B23F8A83-AC28-8BE7-128C-6FF9292C9CC4]
    // </editor-fold> 
    public boolean evaluate () {
        BooleanExpression firstArgument = (BooleanExpression) arguments.get(0);
        BooleanExpression secondArgument = (BooleanExpression) arguments.get(1);
        
        return firstArgument.evaluate() || secondArgument.evaluate();
    }

}

