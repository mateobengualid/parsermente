/*
 * SAXParserState.java
 *
 * Created on 11 de agosto de 2007, 16:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package parsers.sax.states;

import java.util.Stack;
import parsers.sax.SAXHandler;

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.84189066-ACA9-2A12-B310-4B912E602635]
// </editor-fold> 
public abstract class SAXParserState
{
    protected SAXHandler handler;

    public SAXParserState(SAXHandler userHandler)
    {
        this.handler = userHandler;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1696EE42-A8BF-2966-BB69-5BE67589CCE9]
    // </editor-fold> 
    public abstract SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws parsers.sax.SAXParserException;

    public abstract boolean canEscape();
    
    public abstract boolean canFinalize();
}
