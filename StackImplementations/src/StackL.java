/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class Implements a SinglyLinked List as a Stack
 * @author Aaron
 * @since September 16, 2014
 */
public class StackL {
    private SinglyLinkedList stack = new SinglyLinkedList();
    
    /**
     * This method pushes an element onto the stack. It depends on nothing.
     * @param n this is the element to be pushed onto the stack
     */
    public void push(int n){
        stack.addFirst(n);
    }
    
    /**
     * This method pops the top element from the stack. It depends on nothing.
     * @return currentInt this is the integer being stored at the top of the stack
     */
    public int pop(){
        int currentInt = (int)(stack.getHead().getElement());
        stack.setHead(stack.getHead().getNext());
        return currentInt;
    }
    
    /**
     * This method returns the element at the top of the stack. It depends on nothing.
     * @return stack.getHead().getElement() this is the integer being stored at the top of the stack.
     */
    public int peek(){
        return (int)(stack.getHead().getElement());
    }
    
}
