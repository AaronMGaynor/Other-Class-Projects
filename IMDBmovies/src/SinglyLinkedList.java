/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *This class creates a singly linked list of Node objects, which take generic
 * inputs.
 * @author Aaron Gaynor
 * @since September 1, 2014
 */
public class SinglyLinkedList<E> {
    public Node head = new Node();
    public Node tail = new Node();
    public int size = 0;
    /**
     * This method returns the first Node object of the list
     * @return null this return value is for instances in which the list holds no
     * Node objects. It depends on the Node class.
     * @return this.head.getNext(); this return value represents the first Node
     * object in the list
     */
    public Node getHead() {
        if(size == 0){
            return null;
        }
        else{
            return this.head.getNext();
        }
    }
    
    /**
     * This method sets a Node object at the head of the list. It depends on the
     * Node class.
     * @param head this is a value for the Node which you wish to become the head
     * of the list
     */
    public void setHead(Node head) {
        if(size == 0){   
            this.head.setNext(head);
            this.tail = head;
        }
        else if(size >= 1){
            head.nextNode = this.head.nextNode;
            this.head.setNext(head);
        }
    }

    /**
     * This method returns the last Node object of the list. It does not depend 
     * on anything.
     * @return this.tail this is a Node object which represents the last object
     * in the list
     */
    public Node getTail() {
        return this.tail;
    }

    /**
     * This method sets a given node at the end of the list. It depends on the
     * Node class.
     * @param newNode this is the node which the user wishes to set as the Tail
     * of the list
     */
    public void setTail(Node newNode) {
        if(size == 0){
            this.head.setNext(newNode);
            tail = newNode;
        }
        else if(size == 1){
            Node headNode = this.head.getNext();
            headNode.setNext(newNode);
            this.tail = newNode;
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    
    /**
     * This method sets the size of the list. It does not depend on anything.
     * @param size this is an integer which represents the desired size of the
     * list.
     */
    public void setSize(int size){
        this.size = size;
    }
    
    /**
     * This method returns the size of the list. It does not depend on anything.
     * @return size this is an integer representation of the size of the list
     */
    public int getSize(){
        return size;
    }
    
    /**
     * This method creates a new node at the head of the list. It depends on the
     * setHead method in SinglyLinkedList
     * @param element this is the desired object to be placed inside of the node
     */
    public void addFirst(E e) {
        Node newNode = new Node(e);
        setHead(newNode);
        size++;
    }
    
    /**
     * This method creates a new node at the tail of the list. It depends on the
     * setTail method in the class SinglyLinkedList.
     * @param element this is the desired object to be placed inside of the newNode.
     */
    public void addLast(E e) {
        Node newNode = new Node(e);
        setTail(newNode);
        size++;
    }
    
    /**
     * This method removes the first node from the list. It depends on nothing.
     */
    public void removeFirst(){
        this.head.setNext(this.getHead().getNext());
        size -= 1;
    }
}
