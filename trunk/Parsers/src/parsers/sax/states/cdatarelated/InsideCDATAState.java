/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.cdatarelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class InsideCDATAState extends SAXParserState
{
    private String CDATA;

    public InsideCDATAState(String CDATA, SAXHandler userHandler)
    {
        super(userHandler);
        this.CDATA = CDATA;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (c == ']')
        {
            return new CDATARBState(CDATA, handler);
        }
        else
        {
            this.CDATA += c;
            return this;
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
