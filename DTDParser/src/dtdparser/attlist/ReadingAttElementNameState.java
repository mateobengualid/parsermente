package dtdparser.attlist;

import dtdparser.*;

/**
 * Se esta leyendo el nombre del elemento que contendra el atributo.
 */
public class ReadingAttElementNameState extends DTDState
{
public ReadingAttElementNameState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == ' ')
{
return new WaitingForAttNameState(this, c);
}
else if(c == '\n')
{
return new WaitingForAttNameState(this, c);
}
else this.readAnotherAttElementNameChar(c);
return this;
}

    private void readAnotherAttElementNameChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 