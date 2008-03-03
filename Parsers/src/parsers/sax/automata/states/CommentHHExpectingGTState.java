/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states;

import parsers.sax.SAXHandler;
import parsers.sax.automata.*;
import java.util.Stack;

/**
 *
 * @author mateo
 */
public class CommentHHExpectingGTState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // No puede ser otra mas que "-" o "-->"
        if (c != '>')
        {
            throw new StackParserException("Two hyphens must be followed by a > inside a comment");
        }
        else
        {
            return new InsideElementState();
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
