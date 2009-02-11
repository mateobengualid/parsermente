/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

/**
 *
 * @author mateo
 */
public class CDATAConstraint extends BooleanExpression
{
    @Override
    public boolean evaluate(ElementChecklist ec)
    {
        return ec.isCdata();
    }
}
