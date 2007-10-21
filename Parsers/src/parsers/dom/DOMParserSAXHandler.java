/*
 * DOMParserSAXHandler.java
 * 
 * Created on 20-oct-2007, 23:16:38
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mateo
 */
//TODO Reemplazar DefaultHandler por SAXHandler
public class DOMParserSAXHandler extends DefaultHandler {
    Documento documento;

   
    Stack<Nodo> stack;
    //Facilita el uso de CDATA
    boolean procesandoCDATA;
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
	if (procesandoCDATA)
	{
	    stack.peek().setCDATA(String.copyValueOf(ch, start, length));
	}
	else
	{
	    stack.peek().setText(String.copyValueOf(ch, start, length));
	}
    }

    @Override
    public void endDocument() throws SAXException
    {
	//Hacer algo si es necesario
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2) throws SAXException
    {
	stack.pop();
    }

    @Override
    public void startDocument() throws SAXException
    {
	//Hacer algo si es necesario
    }

    @Override
    public void startElement(String uri, String localname, String qName, Attributes attrib) throws SAXException
    {	
	Nodo nodo = new Nodo();
	Hashtable<String,String> atributos = new Hashtable<String,String>();
	
	stack.push(nodo);
    }
}
