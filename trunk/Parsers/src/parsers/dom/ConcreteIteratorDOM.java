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
        Node result;
        
        //si tiene hijos retorna el primer hijo
        if(node.hasChildNodes())
        {                        
            result = node.getFirstChild();
        }
        else 
        {   //si tiene hermano derecho lo retorna
            if(node.getBrotherRight() != null)
            {
                result = node.getBrotherRight();
            }
            else
            {
                //mientras no exista el tio derecho
                while(node.getFather().getBrotherRight() == null)
                {
                    //si no es el nodo raiz tiene padre
                    if(node != root)
                    {
                        node = node.getFather();    
                    }
                    else
                    {
                        result = null;
                    }
                }
              
                result = node.getFather().getBrotherRight();                
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
        return nextNode;
    }
}