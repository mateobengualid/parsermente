/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

import parsers.sax.Attributes;

/**
 *
 * @author gabriel
 */
public class Element extends Node
{
    private Attributes attributes;   
    
    public Attributes getAttributes() 
    {
        return attributes;
    }

    public void setAttributes(Attributes attributes) 
    {
        this.attributes = attributes;
    }      
}
