package dtdparser.attlist;

import dtdparser.*;

/**
 * Se ha leido un tag <!ATTLIST, esperar blancos o enters antes de seguir.
 */
public class LTSATTLISTState extends DTDState
{
public LTSATTLISTState(DTDState previousState, char c)
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
else return new ReadingAttElementNameState(this, c);
}
} 