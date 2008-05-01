/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class WaitingAttributeState extends SAXParserState
{
    private String name;
    private Attributes attributes;

    public WaitingAttributeState(String name)
    {
        this.name = name;
        attributes = new Attributes();
    }

    public WaitingAttributeState(String name, Attributes attributes)
    {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Si todavia no llega el nombre o el fin de etiqueta
        if (c == ' ')
        {
            return this;
        }
        // Un elemento vacio
        else if (c == '/')
        {
            return new EmptyElementWaitingForGTState(name, attributes);
        }
        // El final de la etiqueta
        else if (c == '>')
        {
            handler.startElement(name, attributes);
            stack.push(name);
            return new InsideElementState();
        }
        // Una cadena de texto que marca el nombre del atributo
        else
        {
            return new AttributeNameState(name, "" + c, attributes);
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
