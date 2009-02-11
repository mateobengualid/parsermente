/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

/**
 *
 * @author mateo
 */
public class ChildConstraint extends BooleanExpression
{
    private String childName;
    private int minimumChildren;
    private int maximumChildren;

    public String getChildName()
    {
        return childName;
    }

    public void setChildName(String childName)
    {
        this.childName = childName;
    }

    public int getMinimumChilds()
    {
        return minimumChildren;
    }

    public void setMinimumChilds(int minimumChilds)
    {
        this.minimumChildren = minimumChilds;
    }

    public int getMaximumChilds()
    {
        return maximumChildren;
    }

    public void setMaximumChilds(int maximumChilds)
    {
        this.maximumChildren = maximumChilds;
    }

    @Override
    public boolean evaluate(ElementChecklist ec)
    {        
        Integer howManyChildren = ec.getChildrenCount().get(childName);
        if (howManyChildren == null)
        {
            howManyChildren = 0;
        }

        return (minimumChildren <= howManyChildren) && (howManyChildren <= maximumChildren);
    }
}
