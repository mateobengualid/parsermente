package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba ANY
 */
public class ReadingCategoryANState extends DTDState
{
public ReadingCategoryANState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'Y')
{
return new ReadingCategoryANYState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}