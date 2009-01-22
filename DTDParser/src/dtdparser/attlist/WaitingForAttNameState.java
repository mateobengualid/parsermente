package dtdparser.attlist;

import dtdparser.*;

/**
 * Esperando por el nombre del atributo.
 */
public class WaitingForAttNameState extends DTDState
{
public WaitingForAttNameState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
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
else return new ReadingAttributeNameState(this, c);
}
} 