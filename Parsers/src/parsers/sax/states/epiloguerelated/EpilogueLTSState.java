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
 */
public class EpilogueLTSState extends SAXParserState
{
    public EpilogueLTSState()
    {
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '-')
        {
            return new EpilogueLTSHState();
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
