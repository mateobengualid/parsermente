/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states;

import parsers.sax.automata.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * The default state inside an element, when between tags \">FOO<"             >
 */
public class InsideElementState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Expect to find a comment, text, CDATA, or a new element
        if (c == '<')
        {
            return new LTElementState();
        }
        else if (Character.isLetterOrDigit(c))
        {
            // Es un bloque de texto dentro de 
            return new TextElementState(c);
        }
        else
        {
            throw new StackParserException("Error inside " + stack.pop() + " for " + c);
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
