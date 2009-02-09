/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import parsers.dtd.model.DTDState;
import parsers.dtd.start.BeginningSpaceTrailState;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author mateo
 */
public class DTDModelHelper
{
    public DTDModel obtainModel(java.io.InputStream inputStream, int charsToBeRead) throws IOException
    {
        DTDModel model = new DTDModel();
        DTDState actualState = new BeginningSpaceTrailState(null, ' ');
        
        inputStream.reset();

        for (int i = 0; i < charsToBeRead; i++)
        {
            actualState = actualState.consumeCharacter((char)inputStream.read());
        }
        
        if (!(actualState instanceof BeginningSpaceTrailState))
        {
            throw new DTDValidatorException("The documento is not in DTD format.");
        }
        
        return model;
    }
}
