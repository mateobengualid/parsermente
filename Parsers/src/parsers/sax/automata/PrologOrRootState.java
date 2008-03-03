/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata;

import java.util.Stack;
import java.util.jar.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.automata.states.StackParserState;

/**
 *
 * @author mateo
 */
public class PrologOrRootState extends StackParserState
{
    // This is the same object that the StackParser has,
    // linked this way is the safest possibility
    Attributes xmlDocumentAttributes;
    
    public PrologOrRootState(Attributes xmlDocumentAttributes)
    {
        this.xmlDocumentAttributes = xmlDocumentAttributes;
    }
    
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == ' ')
        {
            return this;
        }
        if (c == '<')
        {
            return new FirstTagLTState(xmlDocumentAttributes);
        }
        else
        {
            throw new StackParserException("Bad Format");
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
