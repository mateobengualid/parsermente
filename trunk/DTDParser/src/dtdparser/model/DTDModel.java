/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtdparser.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @author mateo
 */
public class DTDModel
{
    private Hashtable<String, AndExpression> childConstraints;
    private Hashtable<String, ArrayList<AttributeConstraint>> attributesConstraints;

    public Hashtable<String, AndExpression> getChildConstraints()
    {
        return childConstraints;
    }

    public void setChildConstraints(Hashtable<String, AndExpression> childConstraints)
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
}