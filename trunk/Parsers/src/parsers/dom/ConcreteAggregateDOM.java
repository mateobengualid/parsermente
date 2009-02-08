/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

/**
 *
 * @author gabriel
 */
public class ConcreteAggregateDOM implements AggregateDOM
{
    public IteratorDOM getIteratorDOM() 
    {
        ConcreteIteratorDOM iterator = new ConcreteIteratorDOM();
        
        return iterator;
    }
}