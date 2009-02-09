package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba <!ELEMENT.
 */
public class LTSELEState extends DTDState
{
public LTSELEState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'M')
{
return new LTSELEMState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}