package parsers.dtd.element;

import java.util.Hashtable;
import java.util.Iterator;
import parsers.dtd.model.BooleanExpression;
import parsers.dtd.model.DTDState;
import parsers.*;
import parsers.dtd.model.AndExpression;
import parsers.dtd.model.CDATAConstraint;
import parsers.dtd.model.ChildConstraint;
import parsers.dtd.model.DTDValidatorException;
import parsers.dtd.model.OrExpression;
import parsers.dtd.start.BeginningSpaceTrailState;

/**
 * Leer el contenido, blancos incluidos.
 */
public class ReadingContentState extends DTDState
{
    private String elementName;
    private String content = "";
    private Hashtable<String, ChildConstraint> addedUpConstraints = new Hashtable<String, ChildConstraint>();

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public ReadingContentState(DTDState previousState, char c)
    {
        super(previousState);
        elementName = ((WaitingForCategoryOrContentState) previousState).getElementName();
        content += c;
    }

    @Override
    public DTDState consumeCharacter(char c)
    {
        if (c == '>')
        {
            this.addContentToChecklist(c);
            return new BeginningSpaceTrailState(this, c);
        }
        else
        {
            this.readAnotherContentChar(c);
        }
        return this;
    }

    private void addContentToChecklist(char c)
    {
        // Adentro hay solo and
        if (!content.contains("|"))
        {
            AndExpression exp = new AndExpression();
            content = content.substring(1, content.length() - 1);
            String[] operands = content.split(",");

            for (int i = 0; i < operands.length; i++)
            {
                String operand = operands[i];

                if (!operand.equals("#PCDATA"))
                {
                    ChildConstraint cc = produceChildConstraint(operand);
                    addedUpConstraint(cc);                    
                }
                else
                {
                    CDATAConstraint cc = new CDATAConstraint();
                    exp.addArgument(cc);
                }
            }
            
            for (Iterator it = addedUpConstraints.values().iterator(); it.hasNext();)
            {
                ChildConstraint childConstraint = (ChildConstraint)it.next();
                exp.addArgument(childConstraint);
            }           

            if (this.getModel().getChildConstraints().put(elementName, exp) != null)
            {
                throw new DTDValidatorException("The element has already been defined.");
            }
        }
        // Adentro hay solo or
        else if (!content.contains(","))
        {
            OrExpression exp = new OrExpression();
            content = content.substring(1, content.length() - 1);
            String[] operands = content.split("|");

            for (int i = 0; i < operands.length; i++)
            {
                String operand = operands[i];

                if (!operand.equals("#PCDATA"))
                {
                    ChildConstraint cc = produceChildConstraint(operand);
                    addedUpConstraint(cc);
                }
                else
                {
                    CDATAConstraint cc = new CDATAConstraint();
                    exp.addArgument(cc);
                }
            }
            
            for (Iterator it = addedUpConstraints.values().iterator(); it.hasNext();)
            {
                ChildConstraint childConstraint = (ChildConstraint)it.next();
                exp.addArgument(childConstraint);
            }           

            if (this.getModel().getChildConstraints().put(elementName, exp) != null)
            {
                throw new DTDValidatorException("The element has already been defined.");
            }
        }
    }

    /**
     * Esta funcion suma todos los valores de cada constraint, para garantizar que
     * los minimos y maximos esten contemplados correctamente.
     * @param cc
     * @return
     */
    private void addedUpConstraint(ChildConstraint cc)
    {
        if (!addedUpConstraints.containsKey(cc.getChildName()))
        {
            addedUpConstraints.put(cc.getChildName(), cc);
        }
        else
        {
            ChildConstraint previousConstraint = addedUpConstraints.get(cc.getChildName());
            previousConstraint.setMinimumChilds(previousConstraint.getMinimumChilds() + cc.getMinimumChilds());

            if ((cc.getMaximumChilds() == Integer.MAX_VALUE) || (previousConstraint.getMaximumChilds() == Integer.MAX_VALUE))
            {
                previousConstraint.setMaximumChilds(Integer.MAX_VALUE);
            }
            else
            {
                previousConstraint.setMaximumChilds(previousConstraint.getMaximumChilds() + cc.getMaximumChilds());
            }
        }
    }

    private ChildConstraint produceChildConstraint(String operand)
    {

        ChildConstraint cc = new ChildConstraint();

        switch (operand.charAt(operand.length() - 1))
        {
            case '?':
                cc.setMinimumChilds(0);
                cc.setMaximumChilds(1);
                cc.setChildName(operand.substring(0, operand.length() - 1));
                break;
            case '+':
                cc.setMinimumChilds(1);
                cc.setMaximumChilds(Integer.MAX_VALUE);
                cc.setChildName(operand.substring(0, operand.length() - 1));
                break;
            case '*':
                cc.setMinimumChilds(0);
                cc.setMaximumChilds(Integer.MAX_VALUE);
                cc.setChildName(operand.substring(0, operand.length() - 1));
                break;
            default:
                cc.setMinimumChilds(1);
                cc.setMaximumChilds(1);
                cc.setChildName(operand);
                break;
        }

        return cc;
    }

    private void readAnotherContentChar(char c)
    {
        content += c;
    }
} 