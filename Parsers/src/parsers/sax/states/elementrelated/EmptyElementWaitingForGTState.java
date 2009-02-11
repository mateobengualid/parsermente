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
public class EmptyElementWaitingForGTState extends SAXParserState
{
    private String name;
    private Attributes attributes;

    public EmptyElementWaitingForGTState(String name, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == '>')
        {
            handler.startElement(name, attributes);
            handler.endElement(name);
            return new InsideElementState(handler);
        }
        else
        {
            throw new SAXParserException("Bad Format in " + name);
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
