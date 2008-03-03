/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states.elementrelated;

import parsers.sax.automata.states.*;
import parsers.sax.automata.states.elementrelated.EmptyElementWaitingForGTState;
import parsers.sax.automata.states.elementrelated.PrologAttributeNameState;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class WaitingAttributeState extends StackParserState
{
    private String name;
    private Attributes attributes;

    public WaitingAttributeState(String name)
    {
        this.name = name;
        attributes = new Attributes();
    }

    public WaitingAttributeState(String name, Attributes attributes)
    {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
    {
        // Si todavia no llega el nombre o el fin de etiqueta
        if (c == ' ')
        {
            return this;
        }
        // Un elemento vacio
        else if (c == '/')
        {
            return new EmptyElementWaitingForGTState(name, attributes);
        }
        // El final de la etiqueta
        else if (c == '>')
        {
            handler.startElement(name, attributes);
            return new InsideElementState();
        }
        // Una cadena de texto que marca el nombre del atributo
        else
        {
            return new PrologAttributeNameState("" + c);
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
