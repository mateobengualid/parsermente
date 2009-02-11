/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.doctype;

import parsers.sax.states.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.dtd.model.DTDModel;
import parsers.dtd.model.DTDModelHelper;
import parsers.dtd.model.DTDSAXHandler;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class ReadingInlineAboutToCloseState extends SAXParserState
{
    private String doctypeName;
    private StringBuilder inlineDoctype;

    ReadingInlineAboutToCloseState(String doctypeName, StringBuilder inlineDoctype, SAXHandler userHandler)
    {
        super(userHandler);
        this.doctypeName = doctypeName;
        this.inlineDoctype = inlineDoctype;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and parse the DTD chain.
        if (c == '>')
        {
            try
            {
                DTDModelHelper helper = new DTDModelHelper();
                DTDModel model = helper.obtainModel(new StringReader(inlineDoctype.toString()), inlineDoctype.length());
                model.setRootName(doctypeName);
                
                DTDSAXHandler newHandler = new DTDSAXHandler(handler, model);

                handler = newHandler;                
            }
            catch (IOException ex)
            {
                throw new SAXParserException("An error has occured at processing the DOCTYPE, the xml will not be validated.");
            }
            
            return new PrologOrRootState(null, handler);
        }
        else
        {
            throw new SAXParserException("End the DOCTYPE declaration accordingly with ]>.");
        }
    }

    @Override
    public boolean canEscape()
    {
        return false;
    }

    @Override
    public boolean canFinalize()
    {
        return false;
    }
}
