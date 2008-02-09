package xpath.functions;

import xpath.BooleanExpression;
import xpath.Expression;
import xpath.NodeSetExpression;
import xpath.NumberExpression;
import xpath.StringExpression;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.01447C94-FE7E-1A0C-7034-16D69AA6277E]
// </editor-fold> 
public class StringFunction extends StringExpression
{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4C966FCC-F906-3512-E96C-28FE4356D3E8]
    // </editor-fold> 
    public StringFunction()
    {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8D486264-EBCC-4673-44CD-45DB459E84A2]
    // </editor-fold> 
    public String evaluate()
    {
        Expression firstArgument = arguments.get(0);
        String result = "";

        if (firstArgument instanceof NodeSetExpression)
        {
            // TODO Agregar implementacion para devolver el nombre del primer nodo
            // result = !((NodeSetExpression)firstArgument).isEmpty();
            throw new UnsupportedOperationException();
        }
        else if (firstArgument instanceof NumberExpression)
        {
            float evaluation = ((NumberExpression) firstArgument).evaluate();
            
            if (evaluation == Float.POSITIVE_INFINITY)
            {
                result = "Infinity";
            }
            else if (evaluation == Float.NEGATIVE_INFINITY)
            {
                result = "-Infinity";
            }
            else if (evaluation == Float.NaN)
            {
                result = "NaN";
            }
            else
            {
                result = Float.toString(evaluation);            
            }
        }
        else if (firstArgument instanceof StringExpression)
        {
            result = ((StringExpression) firstArgument).evaluate();
        }
        else
        {
            result = Boolean.toString(((BooleanExpression) firstArgument).evaluate());
        }

        return result;
    }
}

