package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.model.DTDAttlistState;

/**
 * Esperando por el tipo del atributo.
 */
public class WaitingForAttributeTypeState extends DTDAttlistState
{
    public WaitingForAttributeTypeState(DTDState previousState, char c)
    {
        super((DTDAttlistState) previousState);
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