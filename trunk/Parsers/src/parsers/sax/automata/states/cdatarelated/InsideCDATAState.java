/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.sax.automata.states.cdatarelated;

import parsers.sax.automata.states.*;
import parsers.sax.automata.states.cdatarelated.CDATARBState;
import java.util.Stack;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class InsideCDATAState extends StackParserState{

    private String CDATA;
    
    public InsideCDATAState(String CDATA)
    {
        this.CDATA = CDATA;
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped,SAXHandler handler) throws StackParserException
    {
        if(c!=']')
        {
            return new CDATARBState(CDATA);
        }
        else
        {
            this.CDATA += c;
            return this;
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return false;
    }
    

}
