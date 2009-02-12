/*
 * SAXParser.java
 *
 * Created on 11 de agosto de 2007, 16:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package parsers.sax;

import parsers.sax.states.PrologOrRootState;
import parsers.sax.states.SAXParserState;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SAXParser
{
    protected Stack<String> stack;
    protected SAXParserState state;
    protected SAXHandler handler;
    protected Attributes xmlDocumentAttributes;

    public SAXParser(SAXHandler handler)
    {
        stack = new Stack<String>();
        xmlDocumentAttributes = new Attributes();
        state = new PrologOrRootState(xmlDocumentAttributes, handler);
        this.handler = handler;
    }

    public void parse(InputStreamReader sb) throws java.io.IOException
    {
        BufferedReader br = new BufferedReader(sb);
        char[] c = new char[1];
        boolean eofReached = (-1 == br.read(c));

        while (!eofReached)
        {
            // Here it should analyze and escape characters
            // Si debe escapar el caracter
            if (c[0] == '&' && state.canEscape())
            {
                // Debo leer las siguientes tres letras para saber si
                // se escribió bien la secuencia de escape para "&lt;"
                // o "&gt;"
                char[] auxCharArray = new char[3];
                br.read(auxCharArray);
                String threeCharString = "" + auxCharArray[0] + auxCharArray[1] + auxCharArray[2];

                if (threeCharString.equals("lt;"))
                {
                    c[0] = '<';
                    state = state.consumeCharacter(c[0], stack, true);
                }
                else if (threeCharString.equals("gt;"))
                {
                    c[0] = '>';
                    state = state.consumeCharacter(c[0], stack, true);
                }
                else if (threeCharString.equals("amp"))
                {
                    // Debo leer el siguiente caracter para saber si conforma
                    // con "&amp;"                    
                    auxCharArray = new char[1];

                    if ((br.read(auxCharArray) != -1) && (auxCharArray[0] == ';'))
                    {
                        c[0] = '&';
                        state = state.consumeCharacter(c[0], stack, true);
                    }
                    else
                    {
                        throw new SAXParserException("Invalid entity.");
                    }
                }
                else if (threeCharString.equals("quo"))
                {
                    // Debo leer dos caracteres para saber si conforma
                    // con "&quot;"
                    auxCharArray = new char[2];

                    if ((br.read(auxCharArray) != -1) && (("" + auxCharArray[0] + auxCharArray[1]).equals("t;")))
                    {
                        c[0] = '"';
                        state = state.consumeCharacter(c[0], stack, true);
                    }
                    else
                    {
                        throw new SAXParserException("Invalid entity.");
                    }
                }
                else if (threeCharString.equals("apo"))
                {
                    // Debo leer el siguiente caracter para saber si conforma
                    // con "&apos;"
                    auxCharArray = new char[2];

                    if ((br.read(auxCharArray) != -1) && (("" + auxCharArray[0] + auxCharArray[1]).equals("s;")))
                    {
                        c[0] = '\'';
                        state = state.consumeCharacter(c[0], stack, true);
                    }
                    else
                    {
                        throw new SAXParserException("Invalid entity.");
                    }
                }
                else
                {
                    throw new SAXParserException("Invalid entity.");
                }
            }
            else
            {
                // If no built-in entity was called.
                state = state.consumeCharacter(c[0], stack, false);
            }
            eofReached = (-1 == br.read(c));
        }

        if (!state.canFinalize())
        {
            throw new SAXParserException("The document was bad formatted or incomplete");
        }
        else
        {
            // Aun si tuviera dtd, solo es necesario al momento de cerrar un elemento,
            // no el documento.
            handler.endDocument();
        }
    }
}
