/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states;

import parsers.sax.automata.*;
import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 * 
 */
public class TextElementState extends StackParserState
{
    private String text;

    public TextElementState(char c)
    {
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (escaped)
        {
            text += c;
            return this;
        }
        else
        {
            if ((c != '&') && (c != '\'') && (c != '\"') && (c != '>'))
            {
                text += c;
                return this;
            }
            else if (c == '<')
            {
                handler.characters(text);
                return new LTElementState();
            }
            else
            {
                throw new StackParserException("Bad Format in " + text + c);
            }
        }

    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
