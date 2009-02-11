/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.epiloguerelated;

import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.SAXParserState;
import parsers.sax.states.commentrelated.CommentState;

/**
 * This is about to end. A "&lt;!-" was read.
 * In case of finding a '-', then it invokes the
 * comment in commentrelated, since it conserves
 * the state to return.
 * @author mateo
 */
public class EpilogueLTSHState extends SAXParserState
{
    public EpilogueLTSHState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == '-')
        {
            return new CommentState(new EpilogueWaitingForEndState(handler), handler);
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
        return false;
    }
}
