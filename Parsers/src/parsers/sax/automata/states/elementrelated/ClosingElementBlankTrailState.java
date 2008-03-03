/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states.elementrelated;

import parsers.sax.automata.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class ClosingElementBlankTrailState extends StackParserState
{
    private String elementName;

    public ClosingElementBlankTrailState(String elementName)
    {
        this.elementName = elementName;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '>')
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
        else
        {
            throw new StackParserException("Bad Name Format in " + elementName);
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
