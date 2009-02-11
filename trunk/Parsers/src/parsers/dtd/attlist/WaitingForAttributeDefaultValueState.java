package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.model.DTDAttlistState;

/**
 * Esperando por el tipo del atributo.
 */
public class WaitingForAttributeDefaultValueState extends DTDAttlistState
{
    public WaitingForAttributeDefaultValueState(DTDState previousState, char c)
    {
        super((DTDAttlistState)previousState);
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == ' ')
        {
            return this;
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return this;
        }
        else
        {
            return new ReadingAttributeDefaultValueState(this, c);
        }
    }
} 