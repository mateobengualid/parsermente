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
 * During
 */
public class AttributeNameState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public AttributeNameState(String name, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.attributes = attributes;
    }

    public AttributeNameState(String name, String lastAttributeName, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Si se acabo el nombre al llegar un blanco
        if ((c == ' ') || ( c == '\t'))
        {
            return new WaitingEqualForAttributeState(name, lastAttributeName, attributes, handler);
        }
        else if (c == '=')
        {
            return new WaitingValueForAttributeState(name, lastAttributeName, attributes, handler);
        }
        else
        {
            this.lastAttributeName += c;
            return this;
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
