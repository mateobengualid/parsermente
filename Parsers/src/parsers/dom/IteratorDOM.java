/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

/**
 *
 * @author gabriel
 */
public interface IteratorDOM 
{
    public Node first();
    public Node next();
    public boolean hasMoreElements();
    public Node getCurrentElement();
}