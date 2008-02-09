/*
 * DOMParser.java
 *
 * Created on 6 de abril de 2007, 18:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package parsers.dom;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

//import org.xml.sax.Parser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException; 

/**
 *  @author user
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.634C0E9C-1A23-54E5-F34A-20D76A40C71B]
// </editor-fold> 
public class DOMParser {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63068A48-CD21-2EDF-2000-A26B2B73BDB1]
    // </editor-fold> 
    public Document parse (File archivo) throws javax.xml.parsers.ParserConfigurationException, parsers.sax.SAXException {
	try
	{
	    Document doc = new Document();

	    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
	    parser.parse(archivo, new DOMParserSAXHandler(doc));

	    return doc;
	}
	catch (IOException ex)
	{
	    Logger.getLogger(DOMParser.class.getName()).log(Level.SEVERE, null, ex);
	    throw new SAXException(ex);
	}
    }
}
