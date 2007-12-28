/*
 * StackParser.java
 *
 * Created on 11 de agosto de 2007, 16:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package parsers.sax.automata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack; 

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.85A74238-D643-459E-E9E2-4C705A831D40]
// </editor-fold> 
public class StackParser {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.49EB4858-B654-5618-A404-94EFCA405F49]
    // </editor-fold> 
    protected Stack<Object> stack;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C4D88B45-94F9-B77D-84B9-657614E972E9]
    // </editor-fold> 
    protected StackParserState state;

    /**
     *  Creates a new instance of StackParser
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.87BF1F70-20C3-B10B-5BCC-95BBEC6E7278]
    // </editor-fold> 
    public StackParser () {
	stack = new Stack<Object>();	
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9D0E194F-435F-A299-BFF3-7E6332D26CA3]
    // </editor-fold> 
    public void parse (InputStreamReader sb) throws java.io.IOException {
	BufferedReader br = new BufferedReader(sb);
	char[] c = new char[1];
	boolean eofReached = false;
		
	while(!eofReached)
	{
	    eofReached = (-1 == br.read(c));
	    state = state.process(c[0],stack);
	}
    }
}
