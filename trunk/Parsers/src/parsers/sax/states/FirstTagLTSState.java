/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.states.doctype.LTSDState;
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

    public FirstTagLTSState(SAXParserState previousState, SAXHandler userHandler)
    {
        super(userHandler);
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Is a <!D for <!DOCTYPE[]>
        if (c == 'D')
        {
            return new LTSDState(handler);
        }
        else // Is a comment
        if (c == '-')
        {
            // TODO Agregar acá la consideración de que podría ser un ENTITY
            return new LTSHState(previousState, handler);
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
