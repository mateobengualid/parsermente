package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba ANY
 */
public class ReadingCategoryANState extends DTDState
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

    public ReadingCategoryANState(DTDState previousState, char c)
    {
elementName = ((ReadingCategoryAState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == 'Y')
        {
            return new ReadingCategoryANYState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}