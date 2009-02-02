/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtdparser.model;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class AttributeConstraint
{
    private String attributeName;
    private String defaultValue;
    private boolean required;
    private boolean implied;
    private boolean fixed;
    private String type;
    private ArrayList<String> enumeratedValues;

    public String getAttributeName()
    {
        return attributeName;
    }

    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue)
    {
        this.defaultValue = defaultValue;
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public boolean isImplied()
    {
        return implied;
    }

    public void setImplied(boolean implied)
    {
        this.implied = implied;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public ArrayList<String> getEnumeratedValues()
    {
        return enumeratedValues;
    }

    public void setEnumeratedValues(ArrayList<String> enumeratedValues)
    {
        this.enumeratedValues = enumeratedValues;
    }

    public boolean isFixed()
    {
        return fixed;
    }

    public void setFixed(boolean fixed)
    {
        this.fixed = fixed;
    }
}
