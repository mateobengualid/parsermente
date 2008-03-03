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
 * During
 */
public class PrologAttributeNameState extends StackParserState{
    private String name; 
    private String lastAttributeName;
    private Attributes attributes;  
    
    public
    PrologAttributeNameState(String name)
    {
        this.name = name;
    }

    public
    PrologAttributeNameState(String name, String lastAttributeName, Attributes attributes)
    {
        this.name = name;
        this.lastAttributeName = lastAttributeName;
        this.attributes = attributes;
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Si se acabo el nombre al llegar un blanco
        if(c==' ')
        {
            return new WaitingEqualForAttributeState(name,lastAttributeName,attributes);
        }
        else if(c=='=')
        {
            return new WaitingValueForAttributeState(name,lastAttributeName,attributes);
        }
        else
        {
            this.lastAttributeName += c;
            return this;
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return true;
    }

}
