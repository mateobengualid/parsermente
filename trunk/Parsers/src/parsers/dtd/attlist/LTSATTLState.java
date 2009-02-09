package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTLState extends DTDState
{
public LTSATTLState(DTDState previousState, char c)
{
super(previousState);
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