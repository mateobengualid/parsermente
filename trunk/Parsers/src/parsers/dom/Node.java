/*
 * Node.java
 * 
 * Created on 20-oct-2007, 23:02:06
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

import java.util.ArrayList;

/**
 *  @author Mateo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7CF46D09-9218-5E72-77BA-2EAC344A3229]
// </editor-fold> 
public class Node 
{
    private Node father;    
    private Node brotherLeft;
    private Node brotherRight;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AD81E811-A89A-08A5-B6B5-698DE5A42BF8]
    // </editor-fold> 
    private ArrayList<Node> children;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.07AD7895-7AEB-3A2A-00EF-C9BFB367C72F]
    // </editor-fold> 
    private String name;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.91A92648-5F2C-6690-E1FB-2D66FD848F43]
    // </editor-fold> 
    public Node () 
    {
	children = new ArrayList<Node>();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E93CCD59-F0E1-3577-B05D-BC5980BD7503]
    // </editor-fold> 
    public String getName () 
    {
	return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.502467FD-6DFD-2925-6FEF-772F5CF70700]
    // </editor-fold> 
    public void setName (String name) 
    {
	this.name = name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9C7847E-51AA-CD1B-C3CE-08FF0E34FCE8]
    // </editor-fold> 
    public ArrayList<Node> getChildren () {
	return children;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EFC5B6A9-DAB7-7083-D450-62EA07A8BA6C]
    // </editor-fold> 
    public void setChildren (ArrayList<Node> hijos) {
	this.children = hijos;
    }
    
    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getBrotherLeft() {
        return brotherLeft;
    }

    public void setBrotherLeft(Node brotherLeft) {
        this.brotherLeft = brotherLeft;
    }

    public Node getBrotherRight() {
        return brotherRight;
    }

    public void setBrotherRight(Node brotherRight) {
        this.brotherRight = brotherRight;
    }
    
    public Node getLastChild()
    {
        if (hasChildNodes())
        {
             return children.get(children.size()-1);
        }
        else
        {
            return null;
        }
    }
    
    public Node getFirstChild()
    {
        if(hasChildNodes())
        {
            return children.get(0);
        }
        else
        {
            return null;
        }
    }
    
    public boolean hasChildNodes()
    {
        boolean value = false;
        
        if(children.size() > 0)
        {
            value = true;
        }        
        
        return value;
    }
}
