/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states;

import parsers.sax.automata.states.cdatarelated.LTSLBState;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 * State for <!
 */
public class LTSState extends StackParserState
{
    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Es por un <!- de comentario
        if (c == '-')
        {
            return new LTSHState();
        }
        // Es por un <![ de un CDATA
        else if (c == '[')
        {
            return new LTSLBState();
        }
        else
        {
            throw new StackParserException("For compatibility reasons, don't use <! as part of a name");
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }
}
