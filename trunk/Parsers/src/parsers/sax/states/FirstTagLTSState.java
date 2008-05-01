/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.commentrelated.LTSHState;

/**
 *
 * @author mateo
 */
public class FirstTagLTSState extends SAXParserState
{
    private SAXParserState previousState;

    public FirstTagLTSState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Is a <!E for <!ENTITY[]>
        //if (c == '?')
        //{
        //    return new PrologNameState("",xmlDocumentAttributes);
        //} else 
        // Is a comment
        if (c == '-')
        {
            // TODO Agregar acá la consideración de que podría ser un ENTITY
            return new LTSHState(previousState);
        }
        // Is the root element
        else
        {
            // Here will check for prolog attributes, for well-formedness, and
            // finally transfer control to 


            throw new SAXParserException("Bad Format for a comment");
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
