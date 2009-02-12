package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.dtd.model.DTDAttlistState;

/**
 * Se esta leyendo el nombre del elemento que contendra el atributo.
 */
public class ReadingAttElementNameState extends DTDAttlistState
{
    public ReadingAttElementNameState(DTDState previousState, char c)
    {
        // There is no previous state as DTDAttlistState, so
        // only the model gets copied.
        super(previousState);
        this.elementName = "" + c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if ((c == ' ') || ( c == '\t'))
        {
            return new WaitingForAttNameState(this, c);
        }
        else if ((c == '\n') || (c == '\r'))
        {
            return new WaitingForAttNameState(this, c);
        }
        else
        {
            this.readAnotherAttElementNameChar(c);
        }
        return this;
    }

    private void readAnotherAttElementNameChar(char c)
    {
        this.elementName += c;
    }
}