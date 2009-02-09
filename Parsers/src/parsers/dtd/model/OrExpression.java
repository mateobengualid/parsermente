/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mateo
 */
public class OrExpression extends BooleanExpression
{
    ArrayList<BooleanExpression> booleanArguments;

    public OrExpression()
    {
        booleanArguments = new ArrayList<BooleanExpression>();
    }

    public void addArgument(BooleanExpression be)
    {
        booleanArguments.add(be);
    }

    @Override
    public boolean evaluate(ElementChecklist ec)
    {
        boolean result = false;
        Iterator<BooleanExpression> it = booleanArguments.iterator();

        while (!result && it.hasNext())
        {
            BooleanExpression expression = it.next();
            result |= expression.evaluate(ec);
        }

        return result;
    }
}
