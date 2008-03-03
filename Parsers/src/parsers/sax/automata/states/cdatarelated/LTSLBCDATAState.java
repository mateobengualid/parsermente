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
 * Stands for <![CDATA
 */
public class LTSLBCDATAState extends StackParserState{

    public
    LTSLBCDATAState()
    {
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws StackParserException
    {
        // Should ask for each character consecutively until CDATA[ is spelled
        if(c=='[')
        {
            // Finalmente, dentro de un CDATA!
            return new InsideCDATAState("");
        }
        else
        {
            throw new StackParserException("Only \"<![CDATA[\" allowed in a XML file");
        }
    }

    @Override
    public
    boolean canEscape()
    {
        return false;
    }

}
