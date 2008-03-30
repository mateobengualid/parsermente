/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.StackParserException;

/**
 *
 * @author mateo
 */
public class ClosingElementState extends StackParserState
{
    private String elementName;

    public ClosingElementState()
    {
        elementName = "";
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '>')
        {
            if (!stack.peek().equals(elementName))
            {
                throw new StackParserException(stack.pop() + " conflicted with " + elementName);
            }
            else
            {
                return new InsideElementState();
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
}
