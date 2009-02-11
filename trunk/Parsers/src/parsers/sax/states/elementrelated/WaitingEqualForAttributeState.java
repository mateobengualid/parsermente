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
public class WaitingEqualForAttributeState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public WaitingEqualForAttributeState(String name, String lastAttributeName, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '=')
        {
            return new WaitingValueForAttributeState(name, lastAttributeName, attributes, handler);
        }
        else
        {
            throw new SAXParserException("Bad attribute in " + name);
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
