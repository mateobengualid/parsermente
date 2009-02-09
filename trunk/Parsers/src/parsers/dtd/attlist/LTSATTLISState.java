package parsers.dtd.attlist;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ATTLIST.
 */
public class LTSATTLISState extends DTDState
{
public LTSATTLISState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'T')
{
return new LTSATTLISTState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}