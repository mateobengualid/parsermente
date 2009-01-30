/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

/**
 *
 * @author gabriel
 */
public class Text extends Node
{
    private boolean isCDATA;

    public boolean isIsCDATA() {
        return isCDATA;
    }

    public void setIsCDATA(boolean isCDATA) {
        this.isCDATA = isCDATA;
    }    
}
