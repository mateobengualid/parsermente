package dtdparser.attlist;

import dtdparser.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSAState extends DTDState
{
public LTSAState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'T')
{
return new LTSATState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}