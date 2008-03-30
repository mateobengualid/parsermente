/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.StackParserException;
import parsers.sax.automata.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * Inside a comment
 */
public class CommentState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '-')
        {
            return new CommentHState();
        }
        else
        {
            return this;
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
