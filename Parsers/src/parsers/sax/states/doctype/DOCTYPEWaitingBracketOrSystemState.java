/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.doctype;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.dtd.model.DTDSAXHandler;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class DOCTYPEWaitingBracketOrSystemState extends SAXParserState
{
    private String doctypeName;

    DOCTYPEWaitingBracketOrSystemState(String doctypeName, SAXHandler userHandler)
    {
        super(userHandler);
        this.doctypeName = doctypeName;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and begin a quest to the real dtd location.
        if ((c == ' ') || ( c == '\t'))
        {
            return this;
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return this;
        }
        else if (c == '[')
        {
            // This calls for the processing of inline DTD rules.
            return new ReadingInlineDOCTYPEDeclarationState(doctypeName, handler);
        }
        else if (c == 'S')
        {
            // This calls for a file reading.
            return new DOCTYPESState(doctypeName, handler);
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
