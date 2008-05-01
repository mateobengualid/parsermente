/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologuerelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class PrologAttributeValueState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private String lastAttributeValue;
    private Attributes attributes;
    private char enclosingChar;

    public PrologAttributeValueState(String name, String lastAttributeName, Attributes attributes, char enclosingChar)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.lastAttributeValue = "";
        this.attributes = attributes;
        this.enclosingChar = enclosingChar;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '<')
        {
            throw new SAXParserException("'<' can't be inside the value of an attribute");
        }
        else if (c == enclosingChar)
        {
            attributes.insertAttribute(lastAttributeName, lastAttributeValue);
            return new WaitingPrologAttributeState(name, attributes);
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

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
