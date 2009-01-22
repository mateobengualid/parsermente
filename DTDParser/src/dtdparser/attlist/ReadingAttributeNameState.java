package dtdparser.attlist;

import dtdparser.*;

/**
 * Se esta leyendo el nombre del atributo.
 */
public class ReadingAttributeNameState extends DTDState
{
public ReadingAttributeNameState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return new WaitingForAttributeTypeState(this, c);
}
else if(c == '\n')
{
return new WaitingForAttributeTypeState(this, c);
}
else this.readAnotherAttributeNameChar(c);
return this;
}

    private void readAnotherAttributeNameChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 