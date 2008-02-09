/*
 * Node.java
 * 
 * Created on 20-oct-2007, 23:02:06
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

import java.util.ArrayList;
import java.util.Map; 

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7CF46D09-9218-5E72-77BA-2EAC344A3229]
// </editor-fold> 
public class Node {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AD81E811-A89A-08A5-B6B5-698DE5A42BF8]
    // </editor-fold> 
    private ArrayList<Node> hijos;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07AD7895-7AEB-3A2A-00EF-C9BFB367C72F]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E2CB63AD-C148-BA24-24E1-7D8594297714]
    // </editor-fold> 
    private String text;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A6102977-01AC-03D0-F7CD-91E5DBEBC36A]
    // </editor-fold> 
    private String CDATA;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6D1DA18D-EAF4-5EE7-A7F2-86F336FFFC91]
    // </editor-fold> 
    private Map attributes;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.91A92648-5F2C-6690-E1FB-2D66FD848F43]
    // </editor-fold> 
    public Node () {
	hijos = new ArrayList<Node>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E93CCD59-F0E1-3577-B05D-BC5980BD7503]
    // </editor-fold> 
    public String getName () {
	return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.502467FD-6DFD-2925-6FEF-772F5CF70700]
    // </editor-fold> 
    public void setName (String name) {
	this.name = name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.31508C8B-0F77-214B-6B2E-42398ED11F4E]
    // </editor-fold> 
    public String getCDATA () {
	return CDATA;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.75A2A110-2258-D5DD-01EC-54582C9F87BE]
    // </editor-fold> 
    public void setCDATA (String CDATA) {
	this.CDATA = CDATA;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FEB0470B-7722-3ACA-22D9-BF3DA9D8F71A]
    // </editor-fold> 
    public Map getAttributes () {
	return attributes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.46DE685B-0A46-4E33-9C93-F07A75C799A1]
    // </editor-fold> 
    public void setAttributes (Map attributes) {
	this.attributes = attributes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9C7847E-51AA-CD1B-C3CE-08FF0E34FCE8]
    // </editor-fold> 
    public ArrayList<Node> getHijos () {
	return hijos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EFC5B6A9-DAB7-7083-D450-62EA07A8BA6C]
    // </editor-fold> 
    public void setHijos (ArrayList<Node> hijos) {
	this.hijos = hijos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5CFD7D87-871C-7028-B78F-EAB57A5DEF8E]
    // </editor-fold> 
    public String getText () {
	return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9C398A63-C8B3-9BC6-1CE2-48F12D72CEF8]
    // </editor-fold> 
    public void setText (String text) {
	this.text = text;
    }
}
