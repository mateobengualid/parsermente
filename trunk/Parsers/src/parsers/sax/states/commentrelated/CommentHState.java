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
 */
public class CommentHState extends SAXParserState
{
    private SAXParserState previousState;

    public CommentHState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '-')
        {
            return new CommentHHExpectingGTState(previousState);
        }
        else
        {
            return new CommentState(previousState);
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
