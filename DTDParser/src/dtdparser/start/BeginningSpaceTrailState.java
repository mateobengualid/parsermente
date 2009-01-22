package dtdparser.start;

import dtdparser.*;

/**
 * Los blancos previos a cualquier etiqueta.
 */
public class BeginningSpaceTrailState extends DTDState
{
public BeginningSpaceTrailState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return this;
}
else if(c == '\n')
{
return this;
}
else if(c == '&')
{
return new LTState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}