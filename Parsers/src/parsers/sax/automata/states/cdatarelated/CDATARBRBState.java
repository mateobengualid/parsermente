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
public class CDATARBRBState extends StackParserState{
    private String CDATA;
    
    public
    CDATARBRBState(String CDATA)
    {
        this.CDATA = CDATA;
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws StackParserException
    {
        // Has formed "]]>" and exits the CDATA section
        if(c==']')
        {
            // TODO Ver si retorna un texto o un evento CDATA
            return new InsideElementState();
        }
        // Has formed only "]]"
        else
        {
            return new InsideCDATAState(CDATA + "]]" + c);
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return false;
    }

}
