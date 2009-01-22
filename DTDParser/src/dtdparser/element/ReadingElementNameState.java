package dtdparser.element;

import dtdparser.*;

/**
 * La cadena que se esta leyendo es el nombre del elemento, esperar por un blanco o enter.
 */
public class ReadingElementNameState extends DTDState
{
public ReadingElementNameState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return new WaitingForCategoryOrContentState(this, c);
}
else if(c == '\n')
{
return new WaitingForCategoryOrContentState(this, c);
}
else this.readAnotherElementNameChar(c);
return this;
}

    private void readAnotherElementNameChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 