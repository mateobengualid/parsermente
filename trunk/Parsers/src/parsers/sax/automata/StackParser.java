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
 *
 * @author Mateo
 */
public class StackParser
{
    protected Stack<Object> stack;
    protected StackParserState state;
    
    /** Creates a new instance of StackParser */
    public StackParser()
    {
	stack = new Stack<Object>();	
    }
    
    public void parse(InputStreamReader sb) throws IOException
    {
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
