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
import org.xml.sax.helpers.DefaultHandler; 

/**
 *  @author Mateo
 *   TODO Reemplazar DefaultHandler por SAXHandler
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.78F3477A-0996-B4B6-F78E-F5251A831471]
// </editor-fold> 
public class DOMParserSAXHandler extends DefaultHandler {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.30A6D56E-5BC9-1FD0-E5F5-6407747585AE]
    // </editor-fold> 
    Documento documento;
    Stack<Nodo> stack;

    /**
     *  Hay que cambiar esta variable por un checkeo por "<![CDATA["
     *  justo antes, o implementarlo como un evento
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FAFBEE79-A851-3F99-A5B3-757CE9C616B5]
    // </editor-fold> 
    boolean procesandoCDATA;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7F231A35-1412-058C-F155-5CDAD81240DB]
    // </editor-fold> 
    public DOMParserSAXHandler (Documento documento) {
	this.documento = documento;
	stack = new Stack<Nodo>();
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5BD2E057-F6EC-E993-8BD1-5B6A10DA4D5B]
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
    // #[regen=yes,id=DCE.648217F4-0EDC-5375-C615-67C4D6F413B2]
    // </editor-fold> 
    public void endDocument () throws parsers.sax.SAXException {
	//El unico hijo es la raiz del documento
	documento.setRaiz(stack.pop().getHijos().get(0));
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.563F9C0C-13FA-FEF4-C19C-1F298C28F3EB]
    // </editor-fold> 
    public void endElement (String uri, String localname, String qName) throws parsers.sax.SAXException {
	stack.pop();
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.74E558C3-CE08-9784-C73A-DD30203645D0]
    // </editor-fold> 
    public void startDocument () throws parsers.sax.SAXException {
	//Artilugio para poder trabajar con los nodos
	stack.push(new Nodo());
    }

    @Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.600F19C6-55CD-8CDC-3EF0-C6284D73D5E8]
    // </editor-fold> 
    public void startElement (String uri, String localname, String qName, Attributes attrib) throws parsers.sax.SAXException {
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