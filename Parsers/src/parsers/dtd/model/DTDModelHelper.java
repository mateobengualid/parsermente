/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import parsers.dtd.start.BeginningSpaceTrailState;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author mateo
 */
public class DTDModelHelper
{
    public DTDModel obtainModel(Reader inputStream, int charsToBeRead) throws IOException
    {
        DTDModel model = new DTDModel();
        DTDState actualState = new BeginningSpaceTrailState(null, ' ');
        actualState.setModel(model);

        for (int i = 0; i < charsToBeRead; i++)
        {
            char c = (char) inputStream.read();
            actualState = actualState.consumeCharacter(c);
        }

        if (!(actualState instanceof BeginningSpaceTrailState))
        {
            throw new DTDValidatorException("The document is not in DTD format.");
        }

        return model;
    }
}
