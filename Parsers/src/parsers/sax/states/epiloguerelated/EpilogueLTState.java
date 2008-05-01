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
 * A comment is incoming and a &lt; was read
 * @author mateo
 */
public class EpilogueLTState extends SAXParserState
{
    public EpilogueLTState()
    {
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '!')
        {
            return new EpilogueLTSState();
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
