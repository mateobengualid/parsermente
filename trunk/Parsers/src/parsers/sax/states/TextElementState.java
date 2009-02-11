/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import parsers.sax.SAXParserException;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * 
 */
public class TextElementState extends SAXParserState
{
    private String text;

    public TextElementState(char c, SAXHandler userHandler)
    {
        super(userHandler);
        this.text = "" + c;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        if (escaped)
        {
            text += c;
            return this;
        }
        else
        {
            if (c == '<')
            {
                handler.characters(text, false);
                return new LTElementState(new InsideElementState(handler), handler);
            }
            // Solo para & y < se requiere chequeo de escape.
            else if (c != '&')
            {
                text += c;
                return this;
            }
            else
            {
                throw new SAXParserException("Bad Format in " + text + c);
            }
        }

    }

    @Override
    public boolean canEscape()
    {
        return true;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
