/*
 * SAXHandler.java
 *
 * Creado el 8 de abril de 2007, a las 15:24
 *
 */

package parsers.sax;


/**
 *  @version 1.00
 *   @author Mateo Bengualid
 *   
 *   Clase que no hace nada, destinada a ser heredada y reescrita
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1134493B-BB20-B790-7226-60B9D019AA94]
// </editor-fold> 
public class SAXHandler {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D1E5CB40-F3A3-16F2-A5A7-77CD31C25A53]
    // </editor-fold> 
    public void startDocument () {new org.xml.sax.helpers.DefaultHandler();}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E00FFF9D-2359-43BB-971F-B96F568F1A41]
    // </editor-fold> 
    public void endDocument () {}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7D4F1416-C413-2837-34B8-202EA22BB1F6]
    // </editor-fold> 
    public void startElement (String uri, String localName, String qName, Attributes atts) {}

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C1A3ADB-B090-9231-894D-A4CA49497E27]
    // </editor-fold> 
    public void endElement (String uri, String localName, String qName) {}    
}
