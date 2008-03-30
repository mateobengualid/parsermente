/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologrelated;

import parsers.sax.Attributes;
import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.states.PrologOrRootState;
import parsers.sax.StackParserException;
import parsers.sax.states.StackParserState;

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

    ClosingPrologDeclarationState(String name, Attributes attributes)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        if (c == '>')
        {
            // TODO Add here some acquisition of the real bullshit prolog data, that is:
            // version, standalone and encoding
            return new PrologOrRootState(null);
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
