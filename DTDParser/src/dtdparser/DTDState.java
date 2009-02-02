/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtdparser;

import dtdparser.model.DTDModel;

/**
 *
 * @author mateo
 */
public abstract class DTDState
{
    private DTDModel model;
    
    public DTDState(DTDState previousState)
    {
        this.model = previousState.getModel();
    }
    
    public abstract DTDState consumeCharacter(char c);

    public DTDModel getModel()
    {
        return model;
    }

    public void setModel(DTDModel model)
    {
        this.model = model;
    }
}
