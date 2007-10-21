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
 *
 * @author user
 */
public class DOMParser 
{
    public Documento parse(File archivo) throws ParserConfigurationException, SAXException
    {
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
