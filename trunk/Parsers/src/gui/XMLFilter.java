/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
 *
 * @author gabriel
 */
public class XMLFilter extends FileFilter
{
    public final static String xml = "xml";

    //Accept all directories and xml files.
    public boolean accept(File f) 
    {
        if (f.isDirectory()) 
        {
            return true;
        }

        String extension = getExtension(f);
        
        if (extension != null) 
        {
            if (extension.equals(xml))
            {
                return true;
            } 
            else 
            {
                return false;                
            }
        }

        return false;
    }

    private String getExtension(File f)
    {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) 
        {
            ext = s.substring(i+1).toLowerCase();
        }
        
        return ext;
    }
    
    //The description of this filter
    public String getDescription() {
        return "Just xml files";
    }
}
