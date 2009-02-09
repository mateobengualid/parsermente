/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.dtd.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import parsers.sax.Attributes;
import parsers.sax.SAXHandler;

/**
 *
 * @author mateo
 */
public class DTDSAXHandler extends SAXHandler
{
    private SAXHandler userSAXHandler;
    private DTDModel model;
    private Stack<ElementChecklist> childrenCount;

    public DTDSAXHandler(SAXHandler userSAXHandler, DTDModel model)
    {
        this.userSAXHandler = userSAXHandler;
        this.model = model;
    }

    @Override
    public void startElement(String name, Attributes atts)
    {
        // Save the previousCount of attributes to check that no one was ommited or added.
        int howManyAttributes = atts.getLength();
        int attributesConstraintsSize = 0;

        // Chequear que los atributos cumplan con las restricciones.
        ArrayList<AttributeConstraint> attributesConstraints = model.getAttributesConstraints().get(name);
        if (attributesConstraints != null)
        {
            attributesConstraintsSize = attributesConstraints.size();

            for (AttributeConstraint attributeConstraint : attributesConstraints)
            {
                String attributeName = attributeConstraint.getAttributeName();
                String attributeValue = atts.getValue(attributeName);
                String attributeDefault = attributeConstraint.getDefaultValue();

                if (attributeValue == null)
                {
                    if (attributeConstraint.isRequired())
                    {
                        // Si es required y no existe, es un error.
                        throw new DTDValidatorException("Attribute " + attributeName + " doesn't exist at element " + name + ".");
                    }
                    else if (!attributeConstraint.isImplied())
                    {
                        // Si no existen los atributos y no es #IMPLIED, agregar sus valores por defecto.
                        atts.insertAttribute(attributeName, attributeDefault);
                    }
                    else
                    {
                        // Si es IMPLIED, sumar uno a la cantidad de atributos leidos, porque si bien no
                        // esta, si fue considerado.
                        howManyAttributes--;
                    }
                }
                else
                {
                    checkForTypeCorrectness(attributeConstraint, attributeValue, name);

                    if (attributeConstraint.isFixed() && (attributeDefault.compareTo(attributeValue) != 0))
                    {
                        // Si el valor de FIXED ha cambiado, es un error.
                        throw new DTDValidatorException("Expected " + attributeDefault + " but found " + attributeValue + " for Attribute " + attributeName + " doesn't exist at element " + name + ".");
                    }
                }
            }
        }

        // Si cumple con el listado, pero hay más atributos de los necesarios en el DTD, entonces hay error.
        if (howManyAttributes > attributesConstraintsSize)
        {
            throw new DTDValidatorException("Undefined attributes where found at element " + name + ".");
        }

        // Incrementar la cantidad de elementos del nombre en la cima de la pila, o agregar uno.
        Integer previousCount = childrenCount.peek().getChildrenCount().get(name);
        if (previousCount != null)
        {
            previousCount++;
        }
        else
        {
            previousCount = 1;
        }
        childrenCount.peek().getChildrenCount().put(name, previousCount);

        // Agregar a la pila un conjunto nuevo de conteo.
        ElementChecklist childrenCheckList = new ElementChecklist();
        childrenCount.push(childrenCheckList);

        // Invocar al SAXHandler provisto por el usuario, para procesarlo sin que note la diferencia..
        userSAXHandler.startElement(name, atts);
    }

    @Override
    public void characters(String chars, boolean isCDATA)
    {
        childrenCount.peek().setCdata(isCDATA);
        userSAXHandler.characters(chars, isCDATA);
    }

    @Override
    public void endElement(String name)
    {
        BooleanExpression childConstraints = model.getChildConstraints().get(name);
        if (!childConstraints.evaluate(childrenCount.pop()))
        {
            throw new DTDValidatorException("A validation problem has arised in the content of element " + name + ".");
        }
        
        userSAXHandler.endElement(name);
    }

    private void checkForTypeCorrectness(AttributeConstraint attributeConstraint, String attributeValue, String name) throws DTDValidatorException
    {
        // Chequear la correspondencia de tipo, basicamente es chequear si tiene CDATA o una enumeración, no se
        // implementa otra cosa.
        if (attributeConstraint.getType().equals("Enumerated") && !attributeConstraint.getEnumeratedValues().contains(attributeValue))
        {
            throw new DTDValidatorException("Found " + attributeValue + ", a non-enumerable value for Attribute " + attributeConstraint.getAttributeName() + " at element " + name + ".");
        }
        else if (!attributeConstraint.getType().equals("CDATA"))
        {
            throw new DTDValidatorException("Unimplemented type.");
        }
    }
}
