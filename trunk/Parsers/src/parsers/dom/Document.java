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
public class Document {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.65965AFE-731E-BC47-41A2-B5E0790BF05B]
    // </editor-fold> 
    private Node raiz;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2F728C7-F2B8-5745-6265-C4935716515A]
    // </editor-fold> 
    public Document () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BB93E225-0AB7-9624-166E-802C31C14371]
    // </editor-fold> 
    public Node getRaiz () {
	return raiz;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F3F0A53-C580-F3E2-3012-1D19A365FC1A]
    // </editor-fold> 
    public void setRaiz (Node raiz) {
	this.raiz = raiz;
    }
}
