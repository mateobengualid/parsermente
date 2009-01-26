package dtdparser.element;

import dtdparser.*;

/**
 * La cadena que se esta leyendo es el nombre del elemento, esperar por un blanco o enter.
 */
public class ReadingElementNameState extends DTDState
{
    private String elementName;

    public ReadingElementNameState(DTDState previousState, char c)
    {
        elementName = c + "";
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == ' ')
        {
            return new WaitingForCategoryOrContentState(this, c);
        }
        else if (c == '\n')
        {
            return new WaitingForCategoryOrContentState(this, c);
        }
        else
        {
            this.readAnotherElementNameChar(c);
        }
        return this;
    }

    private void readAnotherElementNameChar(char c)
    {
        elementName += c;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }
} 