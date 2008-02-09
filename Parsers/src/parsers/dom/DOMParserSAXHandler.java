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
import parsers.sax.Attributes; 
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler; 

/**
 *  @author Mateo
 *     TODO Reemplazar DefaultHandler por SAXHandler
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E367C4B2-BAC8-BDBC-0565-0613BE8B7BA8]
// </editor-fold> 
public class DOMParserSAXHandler extends DefaultHandler {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.06B6B6CE-3A60-6E3F-0206-6CE632C530BB]
    // </editor-fold> 
    Document documento;
    Stack<Node> stack;

    /**
     *  Hay que cambiar esta variable por un checkeo por "<![CDATA["
     *        justo antes, o implementarlo como un evento
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.222E0403-6E2D-6B0B-E52F-9D3D6B4ED3C9]
    // </editor-fold> 
    boolean procesandoCDATA;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9A3000D8-093C-1A58-CF0C-C1CBC62C13DF]
    // </editor-fold> 
    public DOMParserSAXHandler (Document documento) {
	this.documento = documento;
	stack = new Stack<Node>();
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61EB22A9-92CE-568B-B057-212BB4693728]
    // </editor-fold> 
    public void characters (char[] ch, int start, int length) throws parsers.sax.SAXException {
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C093C020-36FE-DBF9-8132-919A3E7E9C59]
    // </editor-fold> 
    public void endDocument () throws parsers.sax.SAXException {
	//El unico hijo es la raiz del documento
	documento.setRaiz(stack.pop().getHijos().get(0));
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8BA09186-ECAA-C2C9-84F0-8FED0BD0FF0A]
    // </editor-fold> 
    public void endElement (String uri, String localname, String qName) throws parsers.sax.SAXException {
	stack.pop();
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.086D0215-D10B-BD20-1D35-B94721EB467D]
    // </editor-fold> 
    public void startDocument () throws parsers.sax.SAXException {
	//Artilugio para poder trabajar con los nodos
	stack.push(new Node());
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.50001D73-6000-72DA-1239-4FEC660BB21C]
    // </editor-fold> 
    public void startElement (String uri, String localname, String qName, Attributes attrib) throws parsers.sax.SAXException {
	Node nodo = new Node();
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