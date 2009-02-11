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
public class DOCTYPESYSTEMState extends SAXParserState
{
    private String doctypeName;

    public DOCTYPESYSTEMState(String doctypeName, SAXHandler userHandler)
    {
        super(userHandler);
        this.doctypeName = doctypeName;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and begin a quest to the real dtd location.
        if (c == ' ')
        {
            return new DOCTYPEWaitingFileNameState(doctypeName, handler);
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return new DOCTYPEWaitingFileNameState(doctypeName, handler);
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

