/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.StackParserException;

/**
 *
 * @author mateo
 */
public class AttributeValueState extends StackParserState
{
    private String name;
    private String lastAttributeName;
    private String lastAttributeValue;
    private Attributes attributes;
    private char enclosingChar;

    public AttributeValueState(String name, String lastAttributeName, Attributes attributes, char enclosingChar)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.lastAttributeValue = "";
        this.attributes = attributes;
        this.enclosingChar = enclosingChar;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '<')
        {
            throw new StackParserException("'<' can't be inside the value of an attribute");
        }
        else if (c == enclosingChar)
        {
            attributes.insertAttribute(lastAttributeName, lastAttributeValue);
            return new WaitingAttributeState(name, attributes);
        }
        else
        {
            lastAttributeValue += c;
            return this;
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
