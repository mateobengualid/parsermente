package dtdparser.element;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Esperar por blancos, enters, o un greater-than
 */
public class ReadingCategoryEMPTYState extends DTDState
{
public ReadingCategoryEMPTYState(DTDState previousState, char c)
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
else if(c == '>')
{
this.addCategoryEmptyToChecklist(c);
return new BeginningSpaceTrailState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}

    private void addCategoryEmptyToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}