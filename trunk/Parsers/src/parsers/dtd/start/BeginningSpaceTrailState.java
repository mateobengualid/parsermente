package parsers.dtd.start;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Los blancos previos a cualquier etiqueta.
 */
public class BeginningSpaceTrailState extends DTDState
{
    public BeginningSpaceTrailState(DTDState previousState, char c)
    {
        super(previousState);
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if ((c == ' ') || ( c == '\t'))
        {
            return this;
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return this;
        }
        else if (c == '<')
        {
            return new LTState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}