package xpath;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.872D836D-07B5-39A5-F55D-8F30AB582955]
// </editor-fold> 
public class FunctionCall extends Expression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2ECD2913-8EF4-ED19-7530-45AC22ADB46A]
    // </editor-fold> 
    private ArrayList<Expression> arguments;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DBDDE54D-B6A7-E1D3-6A8F-A2F00EF40DD3]
    // </editor-fold> 
    public FunctionCall () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B50A1950-7FA1-2519-F106-C7043738B467]
    // </editor-fold> 
    public ArrayList<Expression> getArguments () {
        return arguments;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B61C44CB-74B6-6421-2CF4-060CD5A83098]
    // </editor-fold> 
    public void setArguments (ArrayList<Expression> val) {
        this.arguments = val;
    }

}

