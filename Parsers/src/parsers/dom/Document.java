/*
 * Document.java
 * 
 * Created on 20-oct-2007, 23:01:45
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;


/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.00FE490D-01C3-3622-2E86-CFD722CF8D48]
// </editor-fold> 
public class Document extends Node
{
    private Element prologue;
        
    public Element getPrologue() {
        return prologue;
    }

    public void setPrologue(Element prologue) {
        this.prologue = prologue;
    }    
}
