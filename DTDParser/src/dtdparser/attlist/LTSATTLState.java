package dtdparser.attlist;

import dtdparser.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTLState extends DTDState
{
public LTSATTLState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'I')
{
return new LTSATTLIState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}