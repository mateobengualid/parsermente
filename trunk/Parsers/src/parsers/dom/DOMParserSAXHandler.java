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
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mateo
 */
//TODO Reemplazar DefaultHandler por SAXHandler
public class DOMParserSAXHandler extends DefaultHandler
{
    Documento documento;
    Stack<Nodo> stack;
    //Hay que cambiar esta variable por un checkeo por "<![CDATA["
    //justo antes, o implementarlo como un evento
    boolean procesandoCDATA;

    public DOMParserSAXHandler(Documento documento)
    {
	this.documento = documento;
	stack = new Stack<Nodo>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
	String text = String.copyValueOf(ch, start, length).trim();
	if (procesandoCDATA && (!text.isEmpty()))
	{
	    stack.peek().setCDATA(text);
	}
	else
	{
	    stack.peek().setText(text);
	}
    }

    @Override
    public void endDocument() throws SAXException
    {
	//El unico hijo es la raiz del documento
	documento.setRaiz(stack.pop().getHijos().get(0));
    }

    @Override
    public void endElement(String uri, String localname, String qName) throws SAXException
    {
	stack.pop();
    }

    @Override
    public void startDocument() throws SAXException
    {
	//Artilugio para poder trabajar con los nodos
	stack.push(new Nodo());
    }

    @Override
    public void startElement(String uri, String localname, String qName, Attributes attrib) throws SAXException
    {
	Nodo nodo = new Nodo();
	Hashtable<String, String> atributos = new Hashtable<String, String>();

	stack.peek().getHijos().add(nodo);

	nodo.setName(qName);
	for (int i = 0; i < attrib.getLength(); i++)
	{
	    atributos.put(attrib.getQName(i), attrib.getValue(i));
	}
	nodo.setAttributes(atributos);

	stack.push(nodo);
    }
}