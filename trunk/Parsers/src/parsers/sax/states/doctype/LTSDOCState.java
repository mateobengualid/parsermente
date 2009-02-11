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
public class LTSDOCState extends SAXParserState
{
    public LTSDOCState(SAXHandler userHandler)
    {
        super(userHandler);
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Is a <!DOCT for <!DOCTYPE[]>
        if (c == 'T')
        {
            return new LTSDOCTState(handler);
        }
        else
        {
            // Here will check for prolog attributes, for well-formedness, and
            // finally transfer control to 
            throw new SAXParserException("Bad Format for a comment");
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
