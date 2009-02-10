package parsers.dtd.attlist;

import java.util.ArrayList;
import java.util.Arrays;
import parsers.dtd.model.DTDState;
import parsers.dtd.model.DTDAttlistState;
import parsers.dtd.model.AttributeConstraint;
import parsers.dtd.start.BeginningSpaceTrailState;

/**
 * Se esta leyendo el tipo del atributo, quizas con blancos al final.
 */
public class ReadingAttributeDefaultValueState extends DTDAttlistState
{
    AttributeConstraint attributeConstraint;

    public ReadingAttributeDefaultValueState(DTDState previousState, char c)
    {
        super((DTDAttlistState) previousState);
        this.defaultValue = "" + c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == '>')
        {
            buildAttributeConstraint();
            this.getModel().getAttributesConstraints().get(this.elementName).add(attributeConstraint);

            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            this.readAnotherAttributeDefaultChar(c);
        }
        return new ReadingAttributeTypeState(this, c);
    }

    private void readAnotherAttributeDefaultChar(char c)
    {
        this.defaultValue = "" + c;
    }

    private void buildAttributeConstraint()
    {
        attributeConstraint = new AttributeConstraint();
        attributeConstraint.setAttributeName(attributeName);
        attributeConstraint.setType(attributeType);

        if (attributeType.startsWith("(") && attributeType.endsWith(")"))
        {
            attributeConstraint.setEnumeratedValues(getProcessedEnumeratedValues());
        }

    }

    private ArrayList<String> getProcessedEnumeratedValues()
    {
        String substring = attributeType.substring(1, attributeType.length() - 1);
        return new ArrayList<String>(Arrays.asList(substring.split("|")));
    }
} 