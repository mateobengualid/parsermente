package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.start.BeginningSpaceTrailState;

/**
 * Esperar por blancos, enters, o un greater-than
 */
public class ReadingCategoryANYState extends DTDState
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

    public ReadingCategoryANYState(DTDState previousState, char c)
    {
        super(previousState);
        elementName = ((ReadingCategoryANState) previousState).getElementName();
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
        else if (c == '>')
        {
            this.addCategoryAnyToChecklist(c);
            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }

    private void addCategoryAnyToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}