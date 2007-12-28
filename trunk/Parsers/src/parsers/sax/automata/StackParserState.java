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
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.193E3AFC-38E3-6012-F476-18B5E571E3A6]
// </editor-fold> 
public abstract class StackParserState {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C573A09C-735B-ED2D-3720-D6D377AB51A5]
    // </editor-fold> 
    boolean esEstadoFinal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0748F28B-D034-84A2-9B4E-8F3AA220A131]
    // </editor-fold> 
    public abstract StackParserState process (char c, Stack stack) throws parsers.sax.automata.StackParserException;
}
