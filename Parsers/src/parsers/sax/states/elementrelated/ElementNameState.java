/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.elementrelated;

import parsers.sax.states.*;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class ElementNameState extends SAXParserState
{
    private String name;

    public ElementNameState(String name, SAXHandler userHandler)
    {
        super(userHandler);
        this.name = name;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Si el caracter es escapado, insertarlo en el nombre, sino, procesarlo
        if (escaped)
        {
            name += c;
            return this;
        }
        else
        {
            // Si se termino el nombre, comenzar el procesamiento de los atributos            
            if ((c == ' ') || ( c == '\t'))
            {
                return new WaitingAttributeState(name, handler);
            }
            // TODO Crear una funcion que incorpore el dominio para nombres.
            // No se implementa, considera los namespaces como nombres de elemento.
            else if ((Character.isLetterOrDigit(c)) || (c == ':'))
            {
                name += c;
                return this;
            }
            // Si encuentra un '/'
            else if (c == '/')
            {
                return new EmptyElementWaitingForGTState(name, new Attributes(), handler);
            }
            // Si encuentra un '>'
            else if (c == '>')
            {
                handler.startElement(name, new Attributes());
                stack.push(name);
                return new InsideElementState(handler);
            }
            else
            {
                throw new SAXParserException("Error at name: " + name);
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
