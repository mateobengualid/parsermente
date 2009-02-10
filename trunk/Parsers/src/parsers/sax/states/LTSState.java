/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.states.commentrelated.LTSHState;
import parsers.sax.states.cdatarelated.LTSLBState;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 * State for <!
 */
public class LTSState extends SAXParserState
{
    private SAXParserState previousState;

    public LTSState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Es por un <!- de comentario
        if (c == '-')
        {
            return new LTSHState(previousState);
        }
        // Es por un <![ de un CDATA
        else if (c == '[')
        {
            return new LTSLBState();
        }
        else
        {
            throw new SAXParserException("For compatibility reasons, don't use <! as part of a name");
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