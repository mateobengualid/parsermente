package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATState extends DTDState
{
public LTSATState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'T')
{
return new LTSATTState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}