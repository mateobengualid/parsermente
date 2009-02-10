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
 * During
 */
public class PrologAttributeNameState extends SAXParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public PrologAttributeNameState(String name, Attributes attributes)
    {
        this.lastAttributeName = name;
        this.attributes = attributes;
    }

    public PrologAttributeNameState(String name, String lastAttributeName, Attributes attributes)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Si se acabo el nombre al llegar un blanco
        if (c == ' ')
        {
            return new WaitingEqualForPrologAttributeState(name, lastAttributeName, attributes);
        }
        else if (c == '=')
        {
            return new WaitingValueForPrologAttributeState(name, lastAttributeName, attributes);
        }
        else
        {
            if (this.lastAttributeName != null)
            {
                this.lastAttributeName += c;
            }
            else
            {
                this.lastAttributeName = "" + c;
            }

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