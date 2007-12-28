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
// #[regen=yes,id=DCE.3029B64C-E0E8-A1B1-2D12-5C2A6598ED79]
// </editor-fold> 
public class DOMParser {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AC72F07F-7496-0BF7-D27A-6A612ABB24D7]
    // </editor-fold> 
    public Documento parse (File archivo) throws javax.xml.parsers.ParserConfigurationException, parsers.sax.SAXException {
	try
	{
	    Documento doc = new Documento();

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
