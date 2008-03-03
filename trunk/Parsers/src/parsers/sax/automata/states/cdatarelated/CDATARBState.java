/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.sax.automata.states.cdatarelated;

import parsers.sax.automata.states.*;
import java.util.Stack;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
// TODO Ver si no conviene sacar CDATA como una herencia
public class CDATARBState extends StackParserState{
    private String CDATA;

    public
    CDATARBState(String CDATA)
    {
        this.CDATA = CDATA;
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped,SAXHandler handler) throws StackParserException
    {
        // Has formed "]]"
        if(c==']')
        {
            return new CDATARBRBState(CDATA);
        }
        // Has formed only "]"
        else
        {
            return new InsideCDATAState(CDATA + ']' + c);
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return false;
    }
}
