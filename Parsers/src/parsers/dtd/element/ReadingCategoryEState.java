package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEState extends DTDState
{
    private String elementName;

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public ReadingCategoryEState(DTDState previousState, char c)
    {
        super(previousState);
        // Proviene de leer el nombre del elemento, así que extraerlo.
        elementName = ((WaitingForCategoryOrContentState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == 'M')
        {
            return new ReadingCategoryEMState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}