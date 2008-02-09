package xpath.functions;

import xpath.NumberExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0DF1FFD2-C9D9-4705-2A5A-D20899E01A0F]
// </editor-fold> 
public class RoundFunction extends NumberExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CD013EC1-2994-FF61-38A6-A18A1A910FB4]
    // </editor-fold> 
    public RoundFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.016E6F99-BB32-AE98-B0C1-76FFC8498FBA]
    // </editor-fold> 
    public float evaluate () {
        NumberExpression firstArgument = (NumberExpression) arguments.get(0);
        
        return Math.round(firstArgument.evaluate());
    }

}

