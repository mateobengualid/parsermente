package xpath;

import java.util.ArrayList; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.5EF8522F-2843-D104-EC34-17282D9D2205]
// </editor-fold> 
public class LocationStep extends NodeSetExpression {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C0452B4A-2C57-E707-E282-CAB813994811]
    // </editor-fold> 
    private Axis axis;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.10B9A2B3-0FD4-4294-DA9A-5E6479F05F83]
    // </editor-fold> 
    private ArrayList<Predicate> predicates;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8421ABA8-7EC7-DDB2-364A-97E278FB7D4D]
    // </editor-fold> 
    private NodeTest nodeTest;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.911FB022-F9C6-F855-CDFA-B4B2C190A67F]
    // </editor-fold> 
    private NodeSetExpression context;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BC688729-96D8-3EED-2741-6A5C12005F3D]
    // </editor-fold> 
    public LocationStep () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8F2CDD68-B323-333B-64E4-E06739D13ABB]
    // </editor-fold> 
    public Axis getAxis () {
        return axis;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.73A34C7D-43A7-8D97-1BCE-E38C9005558D]
    // </editor-fold> 
    public void setAxis (Axis val) {
        this.axis = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.CDE815CC-6280-704F-24D6-7EBF6F485174]
    // </editor-fold> 
    public NodeSetExpression getContext () {
        return context;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9C30BA3F-5DCB-F8DD-9698-3CFF993118E6]
    // </editor-fold> 
    public void setContext (NodeSetExpression val) {
        this.context = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C9E11641-9787-0E85-F5B5-2ABFE3A497A0]
    // </editor-fold> 
    public NodeTest getNodeTest () {
        return nodeTest;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A461B0C9-9C18-37A2-9822-600046AC0383]
    // </editor-fold> 
    public void setNodeTest (NodeTest val) {
        this.nodeTest = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.360EFA8F-3B44-3174-BD0C-7FC91E04E851]
    // </editor-fold> 
    public ArrayList<Predicate> getPredicates () {
        return predicates;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B78953DC-7FD2-BF1C-C804-7A2395F61AEA]
    // </editor-fold> 
    public void setPredicates (ArrayList<Predicate> val) {
        this.predicates = val;
    }

}

