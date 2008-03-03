/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.automata.states.prologrelated;

import parsers.sax.automata.states.*;
import java.util.Stack;
import parsers.sax.SAXHandler;
import parsers.sax.automata.StackParserException;

/**
 *
 * @author mateo
 */
public class PrologNameState extends StackParserState
{
    private String name;

    public PrologNameState(String name)
    {
        this.name = name;
    }

    @Override
    public StackParserState consumeCharacter(char c, Stack<String> stack, boolean escaped, SAXHandler handler) throws StackParserException
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
                    throw new StackParserException("A declaration is composed of <?xml foobar ?>");
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
                throw new StackParserException("Error at name: " + name);
            }
        }
    }

    @Override
    public boolean canEscape()
    {
        return true;
    }
}
