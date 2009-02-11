/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class ClosingElementBlankTrailState extends SAXParserState
{
    private String elementName;

    public ClosingElementBlankTrailState(String elementName, SAXHandler userHandler)
    {
        super(userHandler);
        this.elementName = elementName;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '>')
        {
            if (!stack.peek().equals(elementName))
            {
                throw new SAXParserException(stack.pop() + " conflicted with " + elementName);
            }
            else
            {
                return new InsideElementState(handler);
            }
        }
        else
        {
            throw new SAXParserException("Bad Name Format in " + elementName);
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
