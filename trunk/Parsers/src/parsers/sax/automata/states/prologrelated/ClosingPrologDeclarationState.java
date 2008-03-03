/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states.prologrelated;

import parsers.sax.automata.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.automata.PrologOrRootState;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class ClosingPrologDeclarationState extends StackParserState
{
    private String elementName;

    public ClosingPrologDeclarationState()
    {
        elementName = "";
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '>')
        {
            return new PrologOrRootState();
        }
        else
        {
            throw new StackParserException("A declaration is composed of <?xml foo='bar' ?>");
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
