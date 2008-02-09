package xpath.functions;

import xpath.StringExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.DED25CF1-5229-01E2-A4EA-E4453A31402C]
// </editor-fold> 
public class SubstringAfterFunction extends StringExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AB7F0572-1A7C-2959-761F-835DBA182B5D]
    // </editor-fold> 
    public SubstringAfterFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.74FB5C71-30E5-800B-EDFA-3F7F8947928B]
    // </editor-fold> 
    public String evaluate () {
        StringExpression firstArgument = (StringExpression) arguments.get(0);
        StringExpression secondArgument = (StringExpression) arguments.get(1);
        
        return (firstArgument.evaluate().replaceFirst(secondArgument.evaluate(),""));
    }

}

