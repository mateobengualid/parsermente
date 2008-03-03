/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states.elementrelated;

import parsers.sax.automata.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class WaitingEqualForAttributeState extends StackParserState
{
    private String name;
    private String lastAttributeName;
    private Attributes attributes;

    public WaitingEqualForAttributeState(String name, String lastAttributeName, Attributes attributes)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '=')
        {
            return new WaitingValueForAttributeState(name, lastAttributeName, attributes);
        }
        else
        {
            throw new StackParserException("Bad attribute in " + name);
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
