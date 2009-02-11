/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * The default state inside an element, when between tags \">FOO<"             >
 */
public class InsideElementState extends SAXParserState
{
    public InsideElementState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Expect to find a comment, text, CDATA, or a new element
        if (c == '<')
        {
            return new LTElementState(this, handler);
        }
        else if (Character.isLetterOrDigit(c) || (c == ' ') || ((c == '\n') || (c == '\r')))
        {
            // Es un bloque de texto dentro de 
            return new TextElementState(c, handler);
        }
        else
        {
            throw new SAXParserException("Error inside " + stack.pop() + " for " + c);
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
