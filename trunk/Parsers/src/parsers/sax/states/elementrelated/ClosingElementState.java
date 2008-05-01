/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.epiloguerelated.EpilogueWaitingForEndState;
import java.util.EmptyStackException;
import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class ClosingElementState extends SAXParserState
{
    private String elementName;

    public ClosingElementState()
    {
        elementName = "";
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '>')
        {
            try
            {
                if (!stack.peek().equals(elementName))
                {
                    throw new SAXParserException(stack.pop() + " conflicted with " + elementName);
                }
                else
                {
                    handler.endElement(stack.pop());
                    if (!stack.empty())
                    {
                        return new InsideElementState();
                    }
                    else
                    {
                        return new EpilogueWaitingForEndState();
                    }
                }
            }
            catch (EmptyStackException e)
            {
                throw new SAXParserException("More than one root element");
            }
        }
        else if (c == ' ')
        {
            return new ClosingElementBlankTrailState(elementName);
        }
        else
        {
            elementName += c;
            return this;
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
