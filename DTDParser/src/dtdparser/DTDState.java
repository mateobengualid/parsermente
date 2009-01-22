/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtdparser;

/**
 *
 * @author mateo
 */
public abstract class DTDState
{
    public abstract DTDState consumeCharacter(char c);
}
