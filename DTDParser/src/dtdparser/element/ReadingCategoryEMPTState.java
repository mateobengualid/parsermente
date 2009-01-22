package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba EMPTY
 */
public class ReadingCategoryEMPTState extends DTDState
{
public ReadingCategoryEMPTState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'Y')
{
return new ReadingCategoryEMPTYState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}