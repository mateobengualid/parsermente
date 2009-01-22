package dtdparser.element;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Leer el contenido, blancos incluidos.
 */
public class ReadingContentState extends DTDState
{
public ReadingContentState(DTDState previousState, char c)
{
//TODO: Llenar con algo si hace falta, o borrar.
}

@Override
public DTDState consumeCharacter(char c)
{
if(c == '>')
{
this.addContentToChecklist(c);
return new BeginningSpaceTrailState(this, c);
}
else this.readAnotherContentChar(c);
return this;
}

    private void addContentToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void readAnotherContentChar(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
} 