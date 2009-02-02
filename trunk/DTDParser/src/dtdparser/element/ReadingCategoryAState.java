package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba ANY
 */
public class ReadingCategoryAState extends DTDState
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

    public ReadingCategoryAState(DTDState previousState, char c)
    {
        super(previousState);
        elementName = ((WaitingForCategoryOrContentState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == 'N')
        {
            return new ReadingCategoryANState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}