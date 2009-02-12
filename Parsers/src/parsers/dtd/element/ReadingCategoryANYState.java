package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.model.ChildConstraint;
import parsers.dtd.model.DTDValidatorException;
import parsers.dtd.model.ElementConstraint;
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
        if ((c == ' ') || ( c == '\t'))
        {
            return this;
        }
        else if ((c == '\n') || (c == '\r'))
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
        ElementConstraint ec = new ElementConstraint();
        ec.setAny(true);
        ec.setEmpty(false);
        if (this.getModel().getChildConstraints().put(elementName, ec) != null)
        {
            throw new DTDValidatorException("The element has already been defined.");
        }
    }
}