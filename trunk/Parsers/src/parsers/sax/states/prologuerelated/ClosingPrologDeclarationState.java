/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologuerelated;

import parsers.sax.Attributes;
import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.states.PrologOrRootState;
import parsers.sax.SAXParserException;
import parsers.sax.states.SAXParserState;

/**
 *
 * @author mateo
 */
public class ClosingPrologDeclarationState extends SAXParserState
{
    private String elementName;
    private Attributes attributes;

    public ClosingPrologDeclarationState()
    {
        elementName = "";
    }

    ClosingPrologDeclarationState(String name, Attributes attributes)
    {
        this.elementName = name;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        if (c == '>')
        {
            // TODO Add here some acquisition of the real bullshit prolog data, that is:
            // version, standalone and encoding
            return new PrologOrRootState(null);
        }
        else
        {
            throw new SAXParserException("A declaration is composed of <?xml foo='bar' ?>");
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
