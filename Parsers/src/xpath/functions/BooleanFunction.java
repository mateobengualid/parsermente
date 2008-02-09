package xpath.functions;


import xpath.Expression;
import xpath.NumberExpression;
import xpath.NodeSetExpression; 
import xpath.StringExpression;
import xpath.BooleanExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.311A9E2B-62B4-059D-3050-DA6A583B913E]
// </editor-fold> 
public class BooleanFunction extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.507D92AE-9C7D-3834-7B13-D8527A8002C3]
    // </editor-fold> 
    public BooleanFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E7A63CE-813A-3097-8256-240C3E7F5467]
    // </editor-fold> 
    public boolean evaluate () {
        Expression firstArgument = arguments.get(0);
        boolean result = false;
        
        if(firstArgument instanceof NodeSetExpression)
        {
            result = !((NodeSetExpression)firstArgument).isEmpty();
        }
        else if(firstArgument instanceof NumberExpression)
        {
            result = (((NumberExpression)firstArgument).evaluate()!=0.0f);
        }
        else if(firstArgument instanceof StringExpression)
        {
            result = !((StringExpression)firstArgument).evaluate().isEmpty();
        }
        else
        {
            result = ((BooleanExpression)firstArgument).evaluate();
        }
        
        return result;
    }

}

