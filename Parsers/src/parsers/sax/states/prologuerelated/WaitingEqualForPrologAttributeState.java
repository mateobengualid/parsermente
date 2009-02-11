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
public class WaitingEqualForPrologAttributeState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public WaitingEqualForPrologAttributeState(String name, String lastAttributeName, Attributes attributes, SAXHandler userHandler)
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
            return new WaitingValueForPrologAttributeState(name, lastAttributeName, attributes, handler);
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
