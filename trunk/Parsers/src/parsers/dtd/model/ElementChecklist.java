/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import java.util.Hashtable;

/**
 *
 * @author mateo
 */
public class ElementChecklist
{
    private Hashtable<String, Integer> childrenCount;
    private boolean cdata;

    public ElementChecklist()
    {
        cdata = false;
        childrenCount = new Hashtable<String, Integer>();
    }

    public Hashtable<String, Integer> getChildrenCount()
    {
        return childrenCount;
    }

    public void setChildrenCount(Hashtable<String, Integer> childrenCount)
    {
        this.childrenCount = childrenCount;
    }

    public boolean isEmpty()
    {
        return (childrenCount.size() == 0) && (!cdata);
    }

    public boolean isCdata()
    {
        return cdata;
    }

    public void setCdata(boolean cdata)
    {
        this.cdata = cdata;
    }
}
