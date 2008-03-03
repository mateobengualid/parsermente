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
import parsers.dom.Document;

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C35BFFB3-BE2F-251A-3EBF-26DDB6F12A1D]
// </editor-fold> 
public class Main
{
    /**
     *  @param args the command line arguments
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.983D08A2-CB50-F4D8-2269-E1E590CE679A]
    // </editor-fold> 
    public static void main(String[] args)
    {
        try
        {
            File f = new File("algun.xml");
            Document doc = new DOMParser().parse(f);
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
