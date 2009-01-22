package dtdparser.element;

import dtdparser.*;
import dtdparser.start.BeginningSpaceTrailState;

/**
 * Esperar por blancos, enters, o un greater-than
 */
public class ReadingCategoryANYState extends DTDState
{
public ReadingCategoryANYState(DTDState previousState, char c)
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
this.addCategoryAnyToChecklist(c);
return new BeginningSpaceTrailState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}

    private void addCategoryAnyToChecklist(char c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}