/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.commentrelated;

import parsers.sax.states.*;
import parsers.sax.SAXParserException;
import parsers.sax.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * Inside a comment
 */
public class CommentState extends SAXParserState
{
    private SAXParserState previousState;

    public CommentState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '-')
        {
            return new CommentHState(previousState);
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

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
