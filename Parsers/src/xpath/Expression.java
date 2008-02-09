package xpath;

import java.util.ArrayList;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.56446AF0-D96F-682E-A5EE-058211AC2773]
// </editor-fold> 
public class Expression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.873B01BA-3F20-606F-EADD-4FB86FF07E79]
    // </editor-fold> 
    protected ArrayList<Expression> arguments;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2389FC58-0A30-AE54-C8BC-14AE16B255EA]
    // </editor-fold> 
    public Expression () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FD5DD6DA-849C-FFEA-4C2C-1A8A383C44B0]
    // </editor-fold> 
    public ArrayList<Expression> getArguments () {
        return this.arguments;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A18AE9EE-1F9A-E264-E935-B965CF0B5895]
    // </editor-fold> 
    public void setArguments (ArrayList<Expression> arguments) {
        this.arguments = arguments;
    }

}

