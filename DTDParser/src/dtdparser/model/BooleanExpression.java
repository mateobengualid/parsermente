/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dtdparser.model;

/**
 *
 * @author mateo
 */
public abstract class BooleanExpression {
    public abstract boolean evaluate (ElementChecklist ec);
}
