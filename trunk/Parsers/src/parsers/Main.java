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
import parsers.dom.DOMParser;
import parsers.dom.Document;
import parsers.dom.IteratorDOM;

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
        DOMParser parser = new DOMParser();
        File file = new File("algun.xml");
        Document doc = parser.parse(file);
            
        IteratorDOM iterator = doc.getIteratorDOM();
            
        while(iterator.hasMoreElements())
        {                
            iterator.next();
            System.out.println(iterator.getCurrentElement().toString());                                                
        }
            
        System.out.println("Terminado de parsear");
    }
}