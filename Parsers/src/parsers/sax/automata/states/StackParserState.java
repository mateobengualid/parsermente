/*
 * StackParserState.java
 *
 * Created on 11 de agosto de 2007, 16:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package parsers.sax.automata.states;

import java.util.Stack; 
import parsers.sax.SAXHandler;

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.84189066-ACA9-2A12-B310-4B912E602635]
// </editor-fold> 
public abstract class StackParserState {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D4BF0811-D772-0CE0-83B4-D115F604E249]
    // </editor-fold> 
    private boolean esEstadoFinal;    
    
    /*public StackParserState process(char c, Stack stack) throws parsers.sax.automata.StackParserException;
    {
        
    }*/

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1696EE42-A8BF-2966-BB69-5BE67589CCE9]
    // </editor-fold> 
    public abstract
     StackParserState consumeCharacter (char c, Stack<String> stack,boolean escaped,SAXHandler handler) throws parsers.sax.automata.StackParserException;
    
    public abstract boolean canEscape();
}
