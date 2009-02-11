/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.prologuerelated;

import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;
import parsers.sax.states.SAXParserState;

/**
 *
 * @author mateo
 */
public class WaitingPrologAttributeState extends SAXParserState
{
    private String name;
    private Attributes attributes;

    public WaitingPrologAttributeState(String name, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        attributes = new Attributes();
    }

    public WaitingPrologAttributeState(String name, Attributes attributes, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Si todavia no llega el nombre o el fin de etiqueta
        if (c == ' ')
        {
            return this;
        }
        // Una barra invertida no tiene cabida dentro del prologo
        else if (c == '/')
        {
            throw new SAXParserException("No '/' allowed inside a declaration");
        }
        // El final llega incorrectamente
        else if (c == '>')
        {
            throw new SAXParserException("A declaration is composed of <?xml foo='bar' ?>");
        }
        // Llegado al final de la declaracion        
        else if (c == '?')
        {
            return new ClosingPrologDeclarationState(name, attributes, handler);
        }
        // Una cadena de texto que marca el nombre del atributo
        else
        {
            return new PrologAttributeNameState("" + c, attributes, handler);
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
