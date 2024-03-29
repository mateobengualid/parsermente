/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.epiloguerelated;

import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.SAXParserState;

/**
 *
 * @author mateo
 * 
 * This state can only handle comments and blanks, anything else is bad.
 * This is the only state that finalizes.
 */
public class EpilogueWaitingForEndState extends SAXParserState
{
    public EpilogueWaitingForEndState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (((c == ' ') || ( c == '\t')) || (c == '\n') || (c == '\r'))
        {
            return this;
        }
        else if (c == '<')
        {
            return new EpilogueLTState(handler);
        }
        else
        {
            throw new SAXParserException("Bad Format after document finalization");
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
        return true;
    }
}
