package xpath.functions;

import xpath.StringExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8671672A-9124-1E13-0AE5-2109A2BFF1C1]
// </editor-fold> 
public class SubstringBeforeFunction extends StringExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5CF469F6-AA85-7696-0838-6C392917CEEC]
    // </editor-fold> 
    public SubstringBeforeFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F7A3C3CB-D3EB-F12C-698D-77493003DDF2]
    // </editor-fold> 
    public String evaluate () {
        StringExpression firstArgument = (StringExpression) arguments.get(0);
        StringExpression secondArgument = (StringExpression) arguments.get(1);
        
        return (firstArgument.evaluate().split(secondArgument.evaluate())[0]);
    }

}

