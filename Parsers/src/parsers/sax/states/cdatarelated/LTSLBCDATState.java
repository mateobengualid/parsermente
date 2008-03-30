/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.sax.states.cdatarelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.StackParserException;

/**
 *
 * @author mateo
 */
public class LTSLBCDATState extends StackParserState{

    public
    LTSLBCDATState()
    {
    }

    @Override
    public
    StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped,SAXHandler handler) throws StackParserException
    {
        // Should ask for each character consecutively until CDATA[ is spelled
        if(c=='A')
        {
            return new LTSLBCDATAState();
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
