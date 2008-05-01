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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.sax.SAXParser;

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
        InputStreamReader sb = null;
        try
        {
            System.out.println("parse");
            File f = new File("algun.xml");
            sb = new FileReader(f);
            SAXParser instance = new SAXParser(new TestHandler());
            instance.parse(sb);

            //File f = new File("algun.xml");
            //SAXParser sp = new SAXParser(handler);
            //Document doc = new DOMParser().parse(f);
            //System.out.println("Terminado de parsear");
        }
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                sb.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //File f = new File("algun.xml");
        //SAXParser sp = new SAXParser(handler);
        //Document doc = new DOMParser().parse(f);
        //System.out.println("Terminado de parsear");
    }
}
