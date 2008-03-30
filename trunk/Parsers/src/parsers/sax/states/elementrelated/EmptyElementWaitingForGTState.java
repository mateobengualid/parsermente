/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.StackParserException;

/**
 *
 * @author mateo
 */
public class EmptyElementWaitingForGTState extends StackParserState
{
    private String name;
    private Attributes attributes;

    public EmptyElementWaitingForGTState(String name, Attributes attributes)
    {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '>')
        {
            handler.startElement(name, attributes);
            handler.endElement(name);
            return new InsideElementState();
        }
        else
        {
            throw new StackParserException("Bad Format in " + name);
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
