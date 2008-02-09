package xpath.functions;

import java.util.Iterator;
import xpath.Expression;
import xpath.StringExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0D5523E7-7C5E-EF3B-2802-F4606B8C918D]
// </editor-fold> 
public class ConcatFunction extends StringExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ABBCE56C-EE49-DD3E-17E8-B564D39D0A62]
    // </editor-fold> 
    public ConcatFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6DE0634B-1160-D4BA-C5B2-3E168879EEB6]
    // </editor-fold> 
    public String evaluate () {
        StringBuffer sb = new StringBuffer();

        for (Iterator<Expression> it = arguments.iterator(); it.hasNext();)
        {
            StringExpression stringArgument = (StringExpression) it.next();

            sb.append(stringArgument.evaluate());
        }

        return (sb.toString());
    }
}

