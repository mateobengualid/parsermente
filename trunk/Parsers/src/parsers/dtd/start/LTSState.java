package parsers.dtd.start;

import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.attlist.LTSAState;

/**
 * La cadena lesser-than+signo de admiracion (aqui s de shout).
 */
public class LTSState extends DTDState
{
public LTSState(DTDState previousState, char c)
{
super(previousState);
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == 'E')
{
return new LTSEState(this, c);
}
else if(c == 'A')
{
return new LTSAState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}