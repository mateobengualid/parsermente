/*
 * Main.java
 * 
 * Created on 23-sep-2007, 13:50:24
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import parsers.dom.DOMParser;
import parsers.dom.Documento;


/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8D440371-8286-EB39-7BDF-C0E53162CB23]
// </editor-fold> 
public class Main {

    /**
     *  @param args the command line arguments
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CCB1DDA9-C576-AADC-7252-66559121FFD8]
    // </editor-fold> 
    public static void main (String[] args) {
	try
	{
	    File f = new File("algun.xml");
	    Documento doc = new DOMParser().parse(f);	    
	    System.out.println("Terminado de parsear");
	}
	catch (ParserConfigurationException ex)
	{
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	    ex.printStackTrace();
	}
	catch (SAXException ex)
	{
	    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	    ex.printStackTrace();
	}
    }

}
