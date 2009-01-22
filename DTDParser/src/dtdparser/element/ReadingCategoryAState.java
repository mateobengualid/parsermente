package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba ANY
 */
public class ReadingCategoryAState extends DTDState
{
public ReadingCategoryAState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'N')
{
return new ReadingCategoryANState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}