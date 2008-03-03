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
 * State for <!-
 */
public class LTSHState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '-')
        {
            return new CommentState();
        }
        else
        {
            throw new StackParserException("Bad Format in a Comment");
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
