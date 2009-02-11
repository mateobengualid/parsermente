/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author mateo
 */
public class DTDModel
{
    private String rootName;
    private Hashtable<String, BooleanExpression> childConstraints;
    private Hashtable<String, ArrayList<AttributeConstraint>> attributesConstraints;

    public DTDModel()
    {
        rootName = "";
        childConstraints = new Hashtable<String, BooleanExpression>();
        attributesConstraints = new Hashtable<String, ArrayList<AttributeConstraint>>();
    }

    public Hashtable<String, BooleanExpression> getChildConstraints()
    {
        return childConstraints;
    }

    public void setChildConstraints(Hashtable<String, BooleanExpression> childConstraints)
    {
        this.childConstraints = childConstraints;
    }

    public Hashtable<String, ArrayList<AttributeConstraint>> getAttributesConstraints()
    {
        return attributesConstraints;
    }

    public void setAttributesConstraints(Hashtable<String, ArrayList<AttributeConstraint>> attributesConstraints)
    {
        this.attributesConstraints = attributesConstraints;
    }

    public String getRootName()
    {
        return rootName;
    }

    public void setRootName(String rootName)
    {
        this.rootName = rootName;
    }
}