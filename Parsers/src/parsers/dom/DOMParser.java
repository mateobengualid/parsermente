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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.sax.SAXParser;

/**
 *  @author user
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.634C0E9C-1A23-54E5-F34A-20D76A40C71B]
// </editor-fold> 
public class DOMParser 
{
    private boolean preserveWhitespace;
    
    public DOMParser(boolean preserveWhitespace)
    {
        this.preserveWhitespace = preserveWhitespace;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63068A48-CD21-2EDF-2000-A26B2B73BDB1]
    // </editor-fold> 
    public Document parse(File archivo) throws parsers.sax.SAXParserException 
    {
        Document doc = new Document();
        
        try 
        {
            InputStreamReader sb = null;
            sb = new FileReader(archivo);
            
            DOMParserSAXHandler domParserSAXHandler = new DOMParserSAXHandler(doc);
            domParserSAXHandler.setPreserveWhitespace(this.preserveWhitespace);
            
            SAXParser saxParser = new SAXParser(domParserSAXHandler);
            saxParser.parse(sb);         
        }
        catch (IOException ex) 
        {
            Logger.getLogger(DOMParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doc;
    }
}