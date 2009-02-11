/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.commentrelated;

import parsers.sax.SAXParserException;
import parsers.sax.SAXHandler;
import java.util.Stack;
import parsers.sax.states.SAXParserState;

/**
 *
 * @author mateo
 * State for <!-
 */
public class LTSHState extends SAXParserState
{
    private SAXParserState previousState;

    public LTSHState(SAXParserState previousState, SAXHandler userHandler)
    {
        super(userHandler);
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == '-')
        {
            return new CommentState(previousState, handler);
        }
        else
        {
            throw new SAXParserException("Bad Format in a Comment");
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
