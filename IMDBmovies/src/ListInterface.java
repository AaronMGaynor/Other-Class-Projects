/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *This class creates a generic outline for a List, including getters, setters,
 * and add methods.
 * @author Aaron
 * @since September 1, 2014
 */
public interface ListInterface {
    public Node getHead();
    public void setHead(Node head);
    public Node getTail();
    public void setTail(Node tail);
    public void addFirst(Object element);
    public void addLast(Object element);

    
}
