/*
 * DOMParserSAXHandler.java
 *
 * Created on 20-oct-2007, 23:16:38
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

import java.util.ArrayList;
import java.util.Hashtable; 
import parsers.sax.Attributes; 
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *  @author Mateo
 *     TODO Reemplazar DefaultHandler por SAXHandler
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E367C4B2-BAC8-BDBC-0565-0613BE8B7BA8]
// </editor-fold> 
public class DOMParserSAXHandler extends SAXHandler 
{
    private Stack<Node> stackDOM;
    
    @Override
    public void startDocument()
    {
        Document doc = new Document();
        stackDOM.add(doc);
    }

    @Override
    public void endDocument()
    {
        stackDOM.pop();
    }

    @Override
    public void startElement(String name, Attributes atts)
    {
        Element node = new Element();
        node.setName(name);
        node.setAttributes(atts);
        
        //agregar a mis hermanos
        Node father =  stackDOM.peek();
        ArrayList<Node> childrens = father.getHijos();
        
        Node leftBrother = father.getLastChild();
        
        if (leftBrother != null)
        {
            //me agrego a mi hermano izq como su hermano der
            leftBrother.setBrotherRight(node);
            //agrego a mi hermano izq como mi hermano izq
            node.setBrotherLeft(leftBrother);
        }       
        
        //agregarme al padre como hijo      
        father.getHijos().add(node);        
        //agregar a mi padre
        node.setFather(father);
        //me agrego yo a la pila        
        stackDOM.push(node);
    }

    @Override
    public void endElement(String name)
    {
        stackDOM.pop();
    }

    @Override
    public void characters(String chars, boolean isCDATA)
    {
    }    
}