/*
 * Documento.java
 * 
 * Created on 20-oct-2007, 23:01:45
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsers.dom;

/**
 *
 * @author Mateo
 */
public class Documento {
    private Nodo raiz;

    public Documento()
    {
    }

    public Nodo getRaiz()
    {
	return raiz;
    }

    public void setRaiz(Nodo raiz)
    {
	this.raiz = raiz;
    }
}
