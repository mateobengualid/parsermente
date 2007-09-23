/*
 * StackParserState.java
 *
 * Created on 11 de agosto de 2007, 16:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package parsers.sax.automata;

import java.util.Stack;

/**
 *
 * @author Mateo
 */
public abstract class StackParserState
{
    boolean esEstadoFinal;
    
    public abstract StackParserState process(char c, Stack stack) throws StackParserException;
}
