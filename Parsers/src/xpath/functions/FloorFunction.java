package xpath.functions;

import xpath.NumberExpression; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.79640E48-BED2-61AF-7D92-853E8F4E76A2]
// </editor-fold> 
public class FloorFunction extends NumberExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EF9CE230-0BF6-1527-75F8-CFED3AEBB5FC]
    // </editor-fold> 
    public FloorFunction () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AD0810E7-9101-F50A-A368-F8CAEA4BA6C3]
    // </editor-fold> 
    public float evaluate () {
        return (float) Math.floor(((NumberExpression)arguments.get(0)).evaluate());        
    }

}

