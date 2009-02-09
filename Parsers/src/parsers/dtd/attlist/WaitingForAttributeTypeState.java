package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Esperando por el tipo del atributo.
 */
public class WaitingForAttributeTypeState extends DTDState
{
    public WaitingForAttributeTypeState(DTDState previousState, char c)
    {
        super(previousState);
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == ' ')
        {
            return this;
        }
        else if (c == '\n')
        {
            return this;
        }
        else
        {
            return new ReadingAttributeTypeState(this, c);
        }
    }
} 