package parsers.dtd.attlist;

import java.util.ArrayList;
import java.util.Arrays;
import parsers.dtd.model.DTDState;
import parsers.dtd.model.DTDAttlistState;
import parsers.dtd.model.AttributeConstraint;
import parsers.dtd.model.DTDValidatorException;
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
            ArrayList<AttributeConstraint> ac = this.getModel().getAttributesConstraints().get(this.elementName);

            // Si no se han agregado restricciones de atributos para un elemento.
            if (ac != null)
            {
                ac.add(attributeConstraint);
            }
            else
            {
                ac = new ArrayList<AttributeConstraint>();
                ac.add(attributeConstraint);
                this.getModel().getAttributesConstraints().put(elementName, ac);
            }

            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            this.readAnotherAttributeDefaultChar(c);
        }
        return this;
    }

    private void readAnotherAttributeDefaultChar(char c)
    {
        this.defaultValue += c;
    }

    private void buildAttributeConstraint()
    {
        attributeConstraint = new AttributeConstraint();
        attributeConstraint.setAttributeName(attributeName);
        attributeConstraint.setType(attributeType);

        if (attributeType.startsWith("(") && attributeType.endsWith(")"))
        {
            attributeConstraint.setEnumeratedValues(this.getProcessedEnumeratedValues());
        }

        if ((this.defaultValue.startsWith("\"") && this.defaultValue.endsWith("\"")) ||
            (this.defaultValue.startsWith("'") && this.defaultValue.endsWith("'")))
        {
            // Tiene valor por defecto.
            attributeConstraint.setFixed(false);
            attributeConstraint.setImplied(false);
            attributeConstraint.setRequired(false);
            attributeConstraint.setDefaultValue(defaultValue.substring(1, defaultValue.length() - 1));
        }
        else if (this.defaultValue.matches("#REQUIRED"))
        {
            // Tiene valor requerido.
            attributeConstraint.setFixed(false);
            attributeConstraint.setImplied(false);
            attributeConstraint.setRequired(true);
        }
        else if (this.defaultValue.matches("#IMPLIED"))
        {
            // Tiene valor opcional.
            attributeConstraint.setFixed(false);
            attributeConstraint.setImplied(true);
            attributeConstraint.setRequired(false);
        }
        else if (this.defaultValue.contains("#FIXED"))
        {
            // Tiene valor fijo.
            attributeConstraint.setFixed(true);
            attributeConstraint.setImplied(false);
            attributeConstraint.setRequired(false);

            // Quitar los separadores del valor del atributo antes de usarlo.
            String[] words = defaultValue.trim().split(" ");
            String word = words[words.length - 1];
            attributeConstraint.setDefaultValue(word.substring(1, word.length() - 1));
        }
        else
        {
            throw new DTDValidatorException("Invalid ATTLIST line.");
        }
    }

    private ArrayList<String> getProcessedEnumeratedValues()
    {
        String substring = attributeType.substring(1, attributeType.length() - 1);
        return new ArrayList<String>(Arrays.asList(substring.split("|")));
    }
} 