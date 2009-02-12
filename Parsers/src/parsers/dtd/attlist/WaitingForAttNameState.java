package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.model.DTDAttlistState;

/**
 * Esperando por el nombre del atributo.
 */
public class WaitingForAttNameState extends DTDAttlistState
{
    public WaitingForAttNameState(DTDState previousState, char c)
    {
        super((DTDAttlistState)previousState);
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
        else
        {
            return new ReadingAttributeNameState(this, c);
        }
    }
} 