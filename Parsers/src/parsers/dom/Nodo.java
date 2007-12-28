/*
 * Nodo.java
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
// #[regen=yes,id=DCE.8C703DA4-CAD3-CB54-8374-4FB5510C1057]
// </editor-fold> 
public class Nodo {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9D5872A3-3B2C-850D-E72F-E10B8E5A4811]
    // </editor-fold> 
    private ArrayList<Nodo> hijos;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5A5F1457-33ED-485F-EB36-8BEE7DF01896]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CBD6A793-28E6-2D65-DE1F-8EDCA21AC9C8]
    // </editor-fold> 
    private String text;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5CE196EA-0B31-04C1-75C5-623131F5B2C0]
    // </editor-fold> 
    private String CDATA;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.11C907F4-1621-840A-52C2-E3A1340ACAC1]
    // </editor-fold> 
    private Map attributes;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.339525DB-3475-C6FE-F7E0-22EB7C5DBEF2]
    // </editor-fold> 
    public Nodo () {
	hijos = new ArrayList<Nodo>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BC93724A-3B5A-A7C6-B25B-037545E40CB1]
    // </editor-fold> 
    public String getName () {
	return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A15822BA-2886-5505-FE71-4664C5C86018]
    // </editor-fold> 
    public void setName (String name) {
	this.name = name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5B6B3BE6-9E28-7007-3E09-7FCD2AB08F5B]
    // </editor-fold> 
    public String getCDATA () {
	return CDATA;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C0DC2EB-1FA0-1496-1BAB-BD26F690ED66]
    // </editor-fold> 
    public void setCDATA (String CDATA) {
	this.CDATA = CDATA;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.14BD0BD4-38EE-9B7F-E03C-D7157D04086B]
    // </editor-fold> 
    public Map getAttributes () {
	return attributes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9E94559B-4449-D350-986C-F2C2FF32A1B7]
    // </editor-fold> 
    public void setAttributes (Map attributes) {
	this.attributes = attributes;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2C1756BC-EE2F-04E2-79BB-EF17FD07A799]
    // </editor-fold> 
    public ArrayList<Nodo> getHijos () {
	return hijos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.805D8933-B4FF-F491-EB9D-29B3CE92395D]
    // </editor-fold> 
    public void setHijos (ArrayList<Nodo> hijos) {
	this.hijos = hijos;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EAAB4DA-D956-D8E7-824D-B4F544C48CA1]
    // </editor-fold> 
    public String getText () {
	return text;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0748362E-E1E0-76C7-528E-A648700B8C09]
    // </editor-fold> 
    public void setText (String text) {
	this.text = text;
    }
}
