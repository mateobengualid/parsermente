/*
 * SAXHandler.java
 *
 * Creado el 8 de abril de 2007, a las 15:24
 *
 */

package parsers.sax;

/**
 * @version 1.00
 * @author Mateo Bengualid
 *
 * Clase que no hace nada, destinada a ser heredada y reescrita
 */
public class SAXHandler 
{
    public void startDocument() {new org.xml.sax.helpers.DefaultHandler();}
        
    public void endDocument() {}
    
    public void startElement(String uri, String localName, String qName, Attributes atts) {}

    public void endElement(String uri, String localName, String qName) {}    
}
