package dtdparser.element;

import dtdparser.*;

/**
 * Chequear que escriba <!ELEMENT.
 */
public class LTSELState extends DTDState
{
public LTSELState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'E')
{
return new LTSELEState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}