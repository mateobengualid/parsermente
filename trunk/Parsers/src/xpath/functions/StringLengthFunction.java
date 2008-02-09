package xpath.functions;

import xpath.NumberExpression; 
import xpath.StringExpression;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

// #[regen=yes,id=DCE.C1E1E32D-3C54-EC4A-4C69-B9872055E0E4]
// </editor-fold> 
public class StringLengthFunction extends NumberExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.923C394B-341F-293F-3EBE-B32A9A2F274E]
    // </editor-fold> 
    public StringLengthFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8BCBC545-5EC5-B1C5-0794-E7AADD75072D]
    // </editor-fold> 
    public float evaluate () {
        if(arguments.size()==0)
        {
            // No arguments
            // TODO Agregar la lógica para sacar el nombre del contexto
            throw new UnsupportedOperationException();            
        }
        else
        {
            StringExpression firstArgument = (StringExpression) arguments.get(0);
            
            return firstArgument.evaluate().length();
        }
    }

}

