package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ELEMENT.
 */
public class LTSELEMEState extends DTDState
{
public LTSELEMEState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'N')
{
return new LTSELEMENState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}