/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states;

import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.elementrelated.ElementNameState;
import parsers.sax.states.prologuerelated.PrologNameState;

/**
 *
 * @author mateo
 */
public class FirstTagLTState extends SAXParserState
{
    private Attributes xmlDocumentAttributes;

    public FirstTagLTState(Attributes xmlDocumentAttributes)
    {
        this.xmlDocumentAttributes = xmlDocumentAttributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
    {
        // Is a prolog element
        if (c == '?')
        {
            return new PrologNameState("", xmlDocumentAttributes);
        }
        else // Is a comment or the so much feared <!ENTITY[FOO]>
        if (c == '!')
        {
            // TODO Agregar acá la consideración de que podría ser un ENTITY
            return new FirstTagLTSState(new PrologOrRootState(xmlDocumentAttributes));
        }
        // Is the root element
        else
        {
            // Here will check for prolog attributes, for well-formedness, and
            // finally transfer control to 


            return new ElementNameState("" + c);
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
