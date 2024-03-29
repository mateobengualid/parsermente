package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.dtd.model.DTDAttlistState;
import parsers.*;

/**
 * Se esta leyendo el tipo del atributo.
 */
public class ReadingAttributeTypeState extends DTDAttlistState
{
    public ReadingAttributeTypeState(DTDState previousState, char c)
    {
        super((DTDAttlistState) previousState);
        attributeType = "" + c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if ((c == ' ') || ( c == '\t'))
        {
            return new WaitingForAttributeDefaultValueState(this, c);
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return new WaitingForAttributeDefaultValueState(this, c);
        }
        else
        {
            this.readAnotherAttributeTypeChar(c);
        }
        return this;
    }

    private void readAnotherAttributeTypeChar(char c)
    {
        attributeType += c;
    }
} 