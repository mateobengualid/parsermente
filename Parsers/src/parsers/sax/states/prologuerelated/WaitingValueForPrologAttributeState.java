/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologuerelated;

import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.SAXParserState;

/**
 *
 * @author mateo
 */
public class WaitingValueForPrologAttributeState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public WaitingValueForPrologAttributeState(String name, String lastAttributeName, Attributes attributes)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (!escaped)
        {
            // Still haven't arrived the value
            if (c == ' ')
            {
                return this;
            }
            // Has arrived the tag
            else if ((c == '\'') || (c == '\"'))
            {
                return new PrologAttributeValueState(name, lastAttributeName, attributes, c);
            }
            else
            {
                throw new SAXParserException("Bad attribute format in " + name);
            }
        }
        else
        {
            throw new SAXParserException("No entities allowed for attribute values");
        }
    }

    @Override
    public boolean canEscape()
    {
        // No entities allowed as values
        return true;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
