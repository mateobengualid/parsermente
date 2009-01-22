package dtdparser.attlist;

import dtdparser.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTLIState extends DTDState
{
public LTSATTLIState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'S')
{
return new LTSATTLISState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}