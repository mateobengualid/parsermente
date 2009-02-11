/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.cdatarelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class LTSLBCDAState extends SAXParserState
{
    public LTSLBCDAState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Should ask for each character consecutively until CDATA[ is spelled
        if (c == 'T')
        {
            return new LTSLBCDATState(handler);
        }
        else
        {
            throw new SAXParserException("Only <![CDATA[ allowed in a XML file");
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
