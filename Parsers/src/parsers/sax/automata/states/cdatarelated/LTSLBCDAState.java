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
public class LTSLBCDAState extends StackParserState{

    public
    LTSLBCDAState()
    {
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws StackParserException
    {
        // Should ask for each character consecutively until CDATA[ is spelled
        if(c=='T')
        {
            return new LTSLBCDATState();
        }
        else
        {
            throw new StackParserException("Only <![CDATA[ allowed in a XML file");
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return false;
    }

}
