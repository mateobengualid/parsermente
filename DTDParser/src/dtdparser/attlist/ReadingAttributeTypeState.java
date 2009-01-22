package dtdparser.attlist;

import dtdparser.*;

/**
 * Se esta leyendo el tipo del atributo.
 */
public class ReadingAttributeTypeState extends DTDState
{
public ReadingAttributeTypeState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return new WaitingForAttributeDefaultValueState(this, c);
}
else if(c == '\n')
{
return new WaitingForAttributeDefaultValueState(this, c);
}
else this.readAnotherAttributeTypeChar(c);
return this;
}

    private void readAnotherAttributeTypeChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 