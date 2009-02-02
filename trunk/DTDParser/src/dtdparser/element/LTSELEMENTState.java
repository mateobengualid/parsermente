package dtdparser.element;

import dtdparser.*;

/**
 * Se ha leido un tag <!ELEMENT, esperar blancos o enters antes de seguir.
 */
public class LTSELEMENTState extends DTDState
{
public LTSELEMENTState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return this;
}
else if(c == '\n')
{
return this;
}
else return new ReadingElementNameState(this, c);
}
} 