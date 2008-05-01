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
public class PrologNameState extends SAXParserState
{
    private String name;
    private Attributes attributes;

    public PrologNameState(String name, Attributes attributes)
    {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws SAXParserException
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
            if (c == ' ')
            {
                if (name.equalsIgnoreCase("xml"))
                {
                    return new WaitingPrologAttributeState(name);
                }
                else
                {
                    throw new SAXParserException("A declaration is composed of <?xml foobar ?>");
                }
            }
            // TODO Crear una funcion que incorpore el dominio para nombres
            else if (Character.isLetterOrDigit(c))
            {
                name += c;
                return this;
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
