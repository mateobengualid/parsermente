/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.commentrelated;

import parsers.sax.states.*;
import parsers.sax.SAXParserException;
import parsers.sax.SAXHandler;
import parsers.sax.*;
import java.util.Stack;

/**
 *
 * @author mateo
 */
public class CommentHHExpectingGTState extends SAXParserState
{
    private SAXParserState previousState;

    public CommentHHExpectingGTState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // No puede ser otra mas que "-" o "-->"
        if (c != '>')
        {
            throw new SAXParserException("Two hyphens must be followed by a > inside a comment");
        }
        else
        {
            return previousState;
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
