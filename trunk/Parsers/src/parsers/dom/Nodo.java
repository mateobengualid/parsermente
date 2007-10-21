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
 *
 * @author Mateo
 */
public class Nodo {
    private ArrayList<Nodo> hijos;
    private String name;
    private String text;
    private String CDATA;
    private Map attributes;

    public Nodo()
    {
	hijos = new ArrayList<Nodo>();
    }    
    
    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getCDATA()
    {
	return CDATA;
    }

    public void setCDATA(String CDATA)
    {
	this.CDATA = CDATA;
    }

    public Map getAttributes()
    {
	return attributes;
    }

    public void setAttributes(Map attributes)
    {
	this.attributes = attributes;
    }

    public ArrayList<Nodo> getHijos()
    {
	return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos)
    {
	this.hijos = hijos;
    }

    public String getText()
    {
	return text;
    }

    public void setText(String text)
    {
	this.text = text;
    }
}
