package parsers.dtd.element;

import parsers.dtd.model.DTDState;
import parsers.*;

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
if((c == ' ') || ( c == '\t'))
{
return this;
}
else if((c == '\n') || (c == '\r'))
{
return this;
}
else return new ReadingElementNameState(this, c);
}
} 