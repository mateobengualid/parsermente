package xpath.functions;

import xpath.NumberExpression;
import xpath.StringExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4F837CEF-443C-DC2C-9226-75EBB1599BB1]
// </editor-fold> 
public class SubstringFunction extends StringExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A36392FD-1623-70D9-FC9B-808043E59951]
    // </editor-fold> 
    public SubstringFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7AAC14B9-10E0-A531-EA54-D5A7A12EE7E0]
    // </editor-fold> 
    public String evaluate () {
        StringExpression firstArgument = (StringExpression) arguments.get(0);
        NumberExpression secondArgument = (NumberExpression) arguments.get(1);
        
        int begin = Math.round(secondArgument.evaluate());
        
        if(arguments.size()==3)
        {
            // A numeric third argument
            
            int length = Math.round(((NumberExpression) arguments.get(2)).evaluate());            
            return firstArgument.evaluate().substring(begin-1,length);
        }
        else
        {
            // Only two arguments
            return firstArgument.evaluate().substring(begin-1);
        }        
    }

}

