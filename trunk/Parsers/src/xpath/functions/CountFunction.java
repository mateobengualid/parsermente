package xpath.functions;

import xpath.NodeSetExpression;
import xpath.NumberExpression;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.940026CC-3C8F-B47E-57B0-CE13FF77FB89]
// </editor-fold> 
public class CountFunction extends NumberExpression
{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.684AB770-75E0-6CF3-2206-C38858BB0970]
    // </editor-fold> 
    public CountFunction()
    {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B91CEBB6-EF25-ABB8-AB70-5A1A2CFDBC68]
    // </editor-fold> 
    public float evaluate()
    {
        NodeSetExpression firstArgument = (NodeSetExpression) arguments.get(0);

        return firstArgument.length();
    }
}

