/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

/**
 *
 * @author gabriel
 */
public class ConcreteIteratorDOM implements IteratorDOM
{
    private Node root;
    private Node node;
    private Node nextNode;
    
    public ConcreteIteratorDOM(Node root)
    {
        this.root = root;
        this.nextNode = root;
    }
    
    public Node next() 
    {          
        node = nextNode;
        nextNode = getNextNode();                    
        
        return node;
    }
        
    private Node getNextNode()
    {        
        Node result = nextNode;
        
        //si tiene hijos retorna el primer hijo
        if(result.hasChildNodes())
        {                        
            result = result.getFirstChild();
        }
        else 
        {   //si tiene hermano derecho lo retorna
            if(result.getBrotherRight() != null)
            {
                result = result.getBrotherRight();
            }
            else
            {
                //mientras no exista el tio derecho y no sea la raiz
                while((result.getFather().getBrotherRight() == null) && (result != root))
                {
                    //si no es el nodo raiz tiene padre
                    result = result.getFather();    
                }

                if(result == root)
                {
                    result = null;
                }
                else
                {
                    result = result.getFather().getBrotherRight();                
                }                                
            }
        }
        
        return result;
    }
    
    public boolean hasMoreElements() 
    {
        boolean result;
        
        if(nextNode == null)
        {
            result = false;
        }
        else
        {
            result = true;
        }
        
        return result;
    }

    public Node getCurrentElement() 
    {
        return node;
    }
}