package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba <!ELEMENT.
 */
public class LTSELEMENState extends DTDState
{
public LTSELEMENState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'T')
{
return new LTSELEMENTState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}