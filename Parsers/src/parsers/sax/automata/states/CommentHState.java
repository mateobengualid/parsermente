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
public class CommentHState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '-')
        {
            return new CommentHHExpectingGTState();
        }
        else
        {
            return new CommentState();
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
