/*
 * Documento.java
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
// #[regen=yes,id=DCE.B6F60A5F-CF0B-5B7D-9AF8-C423B68F8B55]
// </editor-fold> 
public class Documento {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E6BE8921-8E68-893A-EF4A-0F853633D050]
    // </editor-fold> 
    private Nodo raiz;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.39BEE87A-DF1B-0FDC-DF4B-75E392D1080E]
    // </editor-fold> 
    public Documento () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.166930F8-3395-86E9-ECF6-B18E690318FE]
    // </editor-fold> 
    public Nodo getRaiz () {
	return raiz;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9D9DE6BD-F836-B004-CAAC-823F02BC8134]
    // </editor-fold> 
    public void setRaiz (Nodo raiz) {
	this.raiz = raiz;
    }
}
