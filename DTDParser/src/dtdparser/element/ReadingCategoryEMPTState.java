package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEMPTState extends DTDState
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

    public ReadingCategoryEMPTState(DTDState previousState, char c)
    {
        elementName = ((ReadingCategoryEMPState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == 'Y')
        {
            return new ReadingCategoryEMPTYState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}