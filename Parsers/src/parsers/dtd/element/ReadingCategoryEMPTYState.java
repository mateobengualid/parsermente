package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.start.BeginningSpaceTrailState;

/**
 * Esperar por blancos, enters, o un greater-than
 */
public class ReadingCategoryEMPTYState extends DTDState
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

    public ReadingCategoryEMPTYState(DTDState previousState, char c)
    {
        super(previousState);
        elementName = ((ReadingCategoryEMPTState) previousState).getElementName();
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
            this.addCategoryEmptyToChecklist(c);
            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }

    private void addCategoryEmptyToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}