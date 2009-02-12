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
        if ((c == '<') && (!escaped))
        {
            return new LTElementState(this, handler);
        }
        else
        {
            // Es un bloque de texto dentro de 
            return new TextElementState(c, handler);
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
