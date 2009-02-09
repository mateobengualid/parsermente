package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

/**
 * Chequear que escriba <!ELEMENT.
 */
public class LTSELEMENState extends DTDState
{
public LTSELEMENState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'T')
{
return new LTSELEMENTState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}