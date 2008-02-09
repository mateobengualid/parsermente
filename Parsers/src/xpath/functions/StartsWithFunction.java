package xpath.functions;

import xpath.BooleanExpression; 
import xpath.StringExpression;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C58DBA10-AFE8-9BB7-A9B9-90EA139B9DC5]
// </editor-fold> 
public class StartsWithFunction extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7CD7849F-AF60-847C-C69D-988EA3118B0D]
    // </editor-fold> 
    public StartsWithFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5CB732AC-A8DC-727A-A690-98D00262FC70]
    // </editor-fold> 
    public boolean evaluate () {
        StringExpression firstArgument = (StringExpression) arguments.get(0);
        StringExpression secondArgument = (StringExpression) arguments.get(1);
        return firstArgument.evaluate().startsWith(secondArgument.evaluate());
    }

}

