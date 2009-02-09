/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

/**
 *
 * @author mateo
 */
public class ElementConstraint extends BooleanExpression
{
    private boolean empty;
    private boolean any;
    private BooleanExpression childrenConstraints;

    public boolean isEmpty()
    {
        return empty;
    }

    public void setEmpty(boolean empty)
    {
        this.empty = empty;
    }

    public boolean isAny()
    {
        return any;
    }

    public void setAny(boolean any)
    {
        this.any = any;
    }

    public BooleanExpression getChildrenConstraints()
    {
        return childrenConstraints;
    }

    public void setChildrenConstraints(BooleanExpression childrenConstraints)
    {
        this.childrenConstraints = childrenConstraints;
    }

    @Override
    public boolean evaluate(ElementChecklist ec)
    {
        if (this.empty)
        {
            return ec.isEmpty();
        }
        else if (!this.any)
        {
            return childrenConstraints.evaluate(ec);
        }
        else
        {
            return true;
        }
    }
}
