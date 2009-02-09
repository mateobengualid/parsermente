/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import java.util.Enumeration;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 */
public class TestHandler extends SAXHandler
{
    @Override
    public void startDocument(Attributes xmlPrologue)
    {
        System.out.println("Comienza el documento");
    }

    @Override
    public void endDocument()
    {
        System.out.println("Termina el documento");
    }
        
    @Override
    public void startElement(String name, Attributes atts)
    {
        System.out.print(name + " - ");
        Enumeration<String> attributes = atts.getAttributes();
        while (attributes.hasMoreElements())
        {
            String attribute = attributes.nextElement();
            System.out.print("[" + attribute + "|" + atts.getValue(attribute) + "]");
        }
        System.out.println();
    }

    @Override
    public void characters(String chars, boolean isCDATA)
    {
        System.out.print((isCDATA ? "CDATA:" : "") + chars);
    }

    @Override
    public void endElement(String name)
    {
        System.out.println("Closing " + name);
    }
}
