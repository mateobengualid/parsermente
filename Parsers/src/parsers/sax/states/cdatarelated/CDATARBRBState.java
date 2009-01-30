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
public class CDATARBRBState extends SAXParserState
{
    private String CDATA;

    public CDATARBRBState(String CDATA)
    {
        this.CDATA = CDATA;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Has formed "]]>" and exits the CDATA section
        if (c == '>')
        {
            // Retorna un evento CDATA
            handler.characters(CDATA,true);
            return new InsideElementState();
        }
        // Has formed only "]]"
        else
        {
            return new InsideCDATAState(CDATA + "]]" + c);
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