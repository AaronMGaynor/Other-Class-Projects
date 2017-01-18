/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *This class defines a Node Object, which is used to store values in the class
 * SinglyLinkedList
 * @author Aaron Gaynor
 * @since September 1, 2014
 */
public class Node<E> {
    private E element;
    public Node nextNode;
    
    public Node(){
    }
    
    public Node(E element){
        this.element = element;
    }
    
    /**
     * The getElement class is a getter for the Object Element in the class Node.
     * It does not depend on any other classes.
     * @return the element that the Node contains 
     */
    public E getElement(){
        return this.element;
    }
    
    /**
     * The setElement class is a setter for the Object element in the class Node.
     * It does not depend on any other classes.
     * @param element
     */
    public void setElement(E element){
        this.element = element;
    }
    
    /**
     * The getNext class is a getter for the Node that this node points to. It
     * does not depend on any other classes.
     * @return the node that this node points to
     */
    public Node getNext(){
        return this.nextNode;
    }
    
    /**
     * The setNext class is a setter for the Node that this node points to. It 
     * does not depend on any other classes.
     * @param next this is the node that is next in the list
     */   
    public void setNext(Node next){
        this.nextNode = next;
    }
    
}
