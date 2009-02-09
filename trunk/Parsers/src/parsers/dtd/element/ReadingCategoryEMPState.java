package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEMPState extends DTDState
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

    public ReadingCategoryEMPState(DTDState previousState, char c)
    {
        super(previousState);

        // Proviene de leer el nombre del elemento, así que extraerlo.
        elementName = ((ReadingCategoryEMState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == 'T')
        {
            return new ReadingCategoryEMPTState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}