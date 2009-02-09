package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.dtd.model.DTDAttlistState;
import parsers.*;

/**
 * Se esta leyendo el nombre del atributo.
 */
public class ReadingAttributeNameState extends DTDAttlistState
{
    public ReadingAttributeNameState(DTDState previousState, char c)
    {
        super((DTDAttlistState) previousState);
        attributeName = "" + c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == ' ')
        {
            return new WaitingForAttributeTypeState(this, c);
        }
        else if (c == '\n')
        {
            return new WaitingForAttributeTypeState(this, c);
        }
        else
        {
            this.readAnotherAttributeNameChar(c);
        }
        return this;
    }

    private void readAnotherAttributeNameChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 