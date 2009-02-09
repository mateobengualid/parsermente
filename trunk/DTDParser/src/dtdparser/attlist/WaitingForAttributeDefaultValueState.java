package dtdparser.attlist;

import dtdparser.*;

/**
 * Esperando por el tipo del atributo.
 */
public class WaitingForAttributeDefaultValueState extends DTDState
{
    public WaitingForAttributeDefaultValueState(DTDState previousState, char c)
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
            return new ReadingAttributeDefaultValueState(this, c);
        }
    }
} 