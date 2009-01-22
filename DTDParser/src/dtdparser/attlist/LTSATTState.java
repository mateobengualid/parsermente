package dtdparser.attlist;

import dtdparser.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTState extends DTDState
{
public LTSATTState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'L')
{
return new LTSATTLState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}