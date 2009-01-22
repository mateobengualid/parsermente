package dtdparser.element;

import dtdparser.*;

/**
 * Esperando la descripcion de la categoria o contenido del elemento..
 */
public class WaitingForCategoryOrContentState extends DTDState
{
public WaitingForCategoryOrContentState(DTDState previousState, char c)
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
else if(c == '(')
{
return new ReadingContentState(this, c);
}
else if(c == 'A')
{
return new ReadingCategoryAState(this, c);
}
else if(c == 'E')
{
return new ReadingCategoryEState(this, c);
}
else { throw new RuntimeException("Unexpected symbol.");}
}
}