/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.StackParserException;
import parsers.sax.*;
import java.util.Stack;
import java.util.jar.Attributes;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 */
public class FirstTagLTState extends StackParserState
{
    Attributes xmlDocumentAttributes;

    public FirstTagLTState(Attributes xmlDocumentAttributes)
    {
        this.xmlDocumentAttributes = xmlDocumentAttributes;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Is a prolog element
        if (c == '?')
        {
            return new parsers.sax.states.prologrelated.PrologNameState("");
        }
        // Is the root element
        else
        {
            // Here will check for prolog attributes, for well-formedness, and
            // finally transfer control to 
            
            
            return new parsers.sax.states.elementrelated.ElementNameState("" + c);
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
