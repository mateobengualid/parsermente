/*
 * Attributes.java
 * 
 * Created on 12/10/2007, 00:11:44
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.sax;

import java.util.Enumeration;
import java.util.Hashtable;


/**
 *  @author GabrieL
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.0420E680-D510-3C14-4D00-AEE07BA5EE75]
// </editor-fold> 
public class Attributes {
    private Hashtable<String,String> attributeTable;

    public Attributes()    
    {
        attributeTable = new Hashtable<String, String>();
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9E94619F-AB26-8F81-D7DD-607A36F13D2C]
    // </editor-fold> 
    public int getLength () 
    {
        return attributeTable.size();
    }
    
    public void insertAttribute(String name, String value)
    {
        attributeTable.put(name, value);
    }
    
    public String getValue(String name)
    {
        return attributeTable.get(name);
    }
    
    public Enumeration<String> getAttributes()
    {
        return attributeTable.keys();
    }
}
