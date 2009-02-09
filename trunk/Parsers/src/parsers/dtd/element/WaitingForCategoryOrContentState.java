package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Esperando la descripcion de la categoria o contenido del elemento..
 */
public class WaitingForCategoryOrContentState extends DTDState
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

    public WaitingForCategoryOrContentState(DTDState previousState, char c)
    {
        super(previousState);

        // Proviene de leer el nombre del elemento, así que extraerlo.
        elementName = ((ReadingElementNameState) previousState).getElementName();
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
        else if (c == '(')
        {
            return new ReadingContentState(this, c);
        }
        else if (c == 'A')
        {
            return new ReadingCategoryAState(this, c);
        }
        else if (c == 'E')
        {
            return new ReadingCategoryEState(this, c);
        }
        else
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }
}