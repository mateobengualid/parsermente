package dtdparser.start;

import dtdparser.*;
import dtdparser.element.LTSELState;

/**
 * Una etiqueta que empieza con E.
 */
public class LTSEState extends DTDState
{
public LTSEState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'L')
{
return new LTSELState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}