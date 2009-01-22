package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEState extends DTDState
{
public ReadingCategoryEState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'M')
{
return new ReadingCategoryEMState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}