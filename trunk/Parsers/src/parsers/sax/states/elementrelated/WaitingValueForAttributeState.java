/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class WaitingValueForAttributeState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public WaitingValueForAttributeState(String name, String lastAttributeName, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
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
                return new AttributeValueState(name, lastAttributeName, attributes, c, handler);
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
