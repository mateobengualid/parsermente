/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologrelated;

import parsers.sax.states.*;
import parsers.sax.states.elementrelated.PrologAttributeNameState;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.StackParserException;

/**
 *
 * @author mateo
 */
public class WaitingPrologAttributeState extends StackParserState
{
    private String name;
    private Attributes attributes;

    public WaitingPrologAttributeState(String name)
    {
        this.name = name;
        attributes = new Attributes();
    }

    public WaitingPrologAttributeState(String name, Attributes attributes)
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
        // Una barra invertida no tiene cabida dentro del prologo
        else if (c == '/')
        {
            throw new StackParserException("No '/' allowed inside a declaration");
        }
        // El final llega incorrectamente
        else if (c == '>')
        {
            throw new StackParserException("A declaration is composed of <?xml foo='bar' ?>");
        }
        // Llegado al final de la declaracion        
        else if (c == '?')
        {
            return new ClosingPrologDeclarationState(name,attributes);
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
