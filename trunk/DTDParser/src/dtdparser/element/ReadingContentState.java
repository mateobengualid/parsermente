package dtdparser.element;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Leer el contenido, blancos incluidos.
 */
public class ReadingContentState extends DTDState
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

    public ReadingContentState(DTDState previousState, char c)
    {
        super(previousState);
        elementName = ((WaitingForCategoryOrContentState) previousState).getElementName();
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == '>')
        {
            this.addContentToChecklist(c);
            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            this.readAnotherContentChar(c);
        }
        return this;
    }

    private void addContentToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void readAnotherContentChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 