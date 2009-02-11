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
public class DOCTYPESYSState extends SAXParserState
{
    private String doctypeName;

    public DOCTYPESYSState(String doctypeName, SAXHandler userHandler)
    {
        super(userHandler);
        this.doctypeName = doctypeName;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and begin a quest to the real dtd location.
        if (c == 'T')
        {
            return new DOCTYPESYSTState(doctypeName, handler);
        }
        else
        {
            throw new SAXParserException("Bad format inside DOCTYPE definition.");
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
