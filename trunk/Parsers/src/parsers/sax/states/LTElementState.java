/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.states.elementrelated.ElementNameState;
import parsers.sax.states.elementrelated.ClosingElementState;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 * Es ni bien uno abre un &lg; y debe decidirse si es un CDATA,
 * un comentario, o un nuevo elemento
 */
public class LTElementState extends SAXParserState
{
    // This previous state is in case a comment is introduced, and
    // it has to remember the previous state
    private SAXParserState previousState;

    public LTElementState(SAXParserState previousState)
    {
        this.previousState = previousState;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Es por comentario o un <![CDATA[]]>
        if (c == '!')
        {
            return new LTSState(previousState);
        }
        // Es por cierre de elemento
        else if (c == '/')
        {
            return new ClosingElementState();
        }
        // TODO Si es letra o símbolo escapado
        else
        {
            return new ElementNameState("" + c);
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
