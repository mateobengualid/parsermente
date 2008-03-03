/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states;

import parsers.sax.automata.states.elementrelated.ElementNameState;
import parsers.sax.automata.states.elementrelated.ClosingElementState;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 * Es ni bien uno abre un &lg; y debe decidirse si es un CDATA,
 * un comentario, o un nuevo elemento
 */
public class LTElementState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Es por comentario o un <![CDATA[]]>
        if (c == '!')
        {
            return new LTSState();
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
}
