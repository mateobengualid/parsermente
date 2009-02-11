/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers.sax.states.doctype;

import parsers.sax.states.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import parsers.dtd.model.DTDModel;
import parsers.dtd.model.DTDModelHelper;
import parsers.dtd.model.DTDSAXHandler;
import parsers.dtd.model.DTDValidatorException;
import parsers.sax.SAXHandler;
import parsers.sax.SAXParserException;

/**
 *
 * @author mateo
 */
public class ReadingFileNameState extends SAXParserState
{
    private String doctypeName;
    private char closingChar;
    private String fileName = "";

    public ReadingFileNameState(String doctypeName, SAXHandler userHandler, char closingChar)
    {
        super(userHandler);
        this.doctypeName = doctypeName;
        this.closingChar = closingChar;
    }

    @Override
    public SAXParserState consumeCharacter(char c, Stack<String> stack, boolean escaped) throws SAXParserException
    {
        // Stop reading and begin a quest to the real dtd location.
        if (c == closingChar)
        {
            FileReader reader = null;
            try
            {
                File f = new File(fileName);
                reader = new FileReader(f);

                DTDModel model = new DTDModelHelper().obtainModel(reader, (int) f.length());
                model.setRootName(doctypeName);
                DTDSAXHandler newHandler = new DTDSAXHandler(handler, model);
                this.handler = newHandler;

                reader.close();
            }
            catch (IOException ex)
            {
                throw new DTDValidatorException("The file could not be opened, the xml will not be validated");
            }
            
            return new WaitingForDOCTYPECloseState(handler);
        }
        else
        {
            fileName += c;
            return this;
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