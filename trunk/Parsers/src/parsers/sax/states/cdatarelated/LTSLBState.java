/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.cdatarelated;

import parsers.sax.SAXHandler;
import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class LTSLBState extends SAXParserState
{
    public LTSLBState()
    {
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Should ask for each character consecutively until CDATA[ is spelled
        if (c == 'C')
        {
            return new LTSLBCState();
        }
        else
        {
            throw new SAXParserException("Only \"<![CDATA[\" allowed in a XML file");
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