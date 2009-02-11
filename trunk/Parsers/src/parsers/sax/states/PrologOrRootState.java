/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 */
public class PrologOrRootState extends SAXParserState
{
    // This is the same object that the StackParser has,
    // linked this way is the safest possibility
    Attributes xmlDocumentAttributes;

    public PrologOrRootState(Attributes xmlDocumentAttributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.xmlDocumentAttributes = xmlDocumentAttributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '<')
        {
            return new FirstTagLTState(xmlDocumentAttributes, handler);
        }
        else if (c == '\n')
        {
            return this;
        }
        else
        {
            throw new SAXParserException("Bad Format");
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
