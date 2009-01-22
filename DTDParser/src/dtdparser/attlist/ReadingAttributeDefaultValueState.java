package dtdparser.attlist;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Se esta leyendo el tipo del atributo, quizas con blancos al final.
 */
public class ReadingAttributeDefaultValueState extends DTDState
{
public ReadingAttributeDefaultValueState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == '>')
{
return new BeginningSpaceTrailState(this, c);
}
else this.readAnotherAttributeDefaultChar(c);
return new ReadingAttributeTypeState(this, c);
}

    private void readAnotherAttributeDefaultChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 