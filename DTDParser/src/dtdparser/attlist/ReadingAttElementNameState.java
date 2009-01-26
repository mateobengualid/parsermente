package dtdparser.attlist;

import dtdparser.*;

/**
 * Se esta leyendo el nombre del elemento que contendra el atributo.
 */
public class ReadingAttElementNameState extends DTDAttlistState
{
    public ReadingAttElementNameState(DTDState previousState, char c)
    {
        // There is no previous state, so null is provided..
        super(null);
        this.attributeName = "" + c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == ' ')
        {
            return new WaitingForAttNameState(this, c);
        }
        else if (c == '\n')
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
        this.attributeName += c;
    }
}