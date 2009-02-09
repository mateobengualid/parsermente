package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTState extends DTDState
{
public LTSATTState(DTDState previousState, char c)
{
super(previousState);
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