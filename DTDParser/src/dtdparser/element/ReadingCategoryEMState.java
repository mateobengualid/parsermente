package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEMState extends DTDState
{
public ReadingCategoryEMState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'P')
{
return new ReadingCategoryEMPState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}