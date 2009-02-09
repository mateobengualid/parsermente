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
public class AndExpression extends BooleanExpression
{
    ArrayList<BooleanExpression> booleanArguments;

    public AndExpression()
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
        boolean result = true;
        Iterator<BooleanExpression> it = booleanArguments.iterator();

        while (result && it.hasNext())
        {
            BooleanExpression expression = it.next();
            result &= expression.evaluate(ec);
        }

        return result;
    }
}
