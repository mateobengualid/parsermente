package dtdparser.attlist;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Se esta leyendo el tipo del atributo, quizas con blancos al final.
 */
public class ReadingAttributeDefaultValueState extends DTDAttlistState
{
public ReadingAttributeDefaultValueState(DTDState previousState, char c)
{
    super((DTDAttlistState)previousState);
this.defaultValue = "" + c;
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
        this.defaultValue = "" + c;
    }
} 