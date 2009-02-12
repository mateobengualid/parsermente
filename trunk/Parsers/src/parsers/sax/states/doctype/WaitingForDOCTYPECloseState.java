/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.doctype;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class WaitingForDOCTYPECloseState extends SAXParserState
{
    WaitingForDOCTYPECloseState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and parse the DTD chain.
        if ((c == ' ') || ( c == '\t'))
        {
            return this;
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return this;
        }
        else if (c== '>')
        {
            return new PrologOrRootState(null, handler);
        }
        else
        {
            throw new SAXParserException("End the DOCTYPE declaration accordingly with ]>.");
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
