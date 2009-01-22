package dtdparser.start;

import dtdparser.*;

/**
 * El primer lesser-than de una etiqueta.
 */
public class LTState extends DTDState
{
public LTState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == '!')
{
return new LTSState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}