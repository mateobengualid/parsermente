package xpath.functions;

import xpath.BooleanExpression; 
import xpath.StringExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.33BBDEF0-F29A-C644-40CB-40ACF9DFD3C8]
// </editor-fold> 
public class ContainsFunction extends BooleanExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CA653561-DE8C-E8C2-67FB-507094FEE00E]
    // </editor-fold> 
    public ContainsFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7C4436F4-4BFA-2CA7-6D34-4D64AC19EAAB]
    // </editor-fold> 
    public boolean evaluate () {
        String firstArgument = ((StringExpression)arguments.get(0)).evaluate();
        String secondArgument = ((StringExpression)arguments.get(1)).evaluate();
        
        return firstArgument.contains(secondArgument);
    }
}

