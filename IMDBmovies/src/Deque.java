
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class creates a Deque Data Structure using a SinglyLinkedList.
 * @author Aaron Gaynor
 * @since September 2, 2014
 */
public class Deque<E> implements Iterable<E>{
    private SinglyLinkedList list = new SinglyLinkedList();
    private int length = 0;
    
    public Deque(){
    }
    
    public Deque(SinglyLinkedList list){
        this.list = list;
        this.length = list.size;
    }
    
    /**
     *This method appends an object to the front of the Deque. It depends on the
     * class SinglyLinkedList.
     * @param element this is the element to put inside of the node
     */
    public void addFirst(E element){
        list.addFirst(element);
        length += 1;
    }
    
    /**
     *This method appends an object to the end of the Deque. It depends on the class
     * SinglyLinkedList.
     * @param element this is the element to put inside of the node
     */
    public void addLast(E element){
        list.addLast(element);
        length += 1;
    }
    
    /**
     *This method removes the first object from the Deque. It depends on the class
     * SinglyLinkedList.
     * @return element this is the element being stored in the first item of the Deque
     */
    public E removeFirst(){
        if(length > 1){
            E element = (E) list.getHead().getElement();
            list.removeFirst();
            length -= 1;
            return element;
        }
        else if (length == 1){
            E element = (E) list.getHead().getElement();
            list.setHead(list.tail);
            list.setTail(list.head);
            length -= 1;
            return element;
        }
        else{
            return null;
        }
    }
    
    /**
     *This method removes the last element from the Deque. It depends on the class
     * SinglyLinkedList.
     * @return element this is the element in the last item of the list.
     */
    public E removeLast(){
        E element = (E) list.getTail();
        Node previousNode = list.getHead();
        Node currentNode = list.getHead();
        if(list.getSize() > 2){
            for(int i=2; i<list.getSize(); i++){
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            list.setTail(currentNode);
        }
        else if (list.getSize() == 2){
            list.setTail(currentNode);
        }
        else if (list.getSize() < 2){
            list.setTail(list.head);
            list.setHead(list.tail);
        }
        length -= 1;
        return element;
     }
    
    /**
     *This method returns the length of the Deque. It depends on nothing.
     * @return this.length this is the length of the Deque.
     */
    public int getLength(){
        return this.length;
    }
    
    /**
     *This is a setter for the length of the Deque. It depends on nothing.
     * @param length this is the desired length of the Deque.
     */
    public void setLength(int length){
        this.length = length;
    }

    /**
     * This method returns a new iterator over the current Deque.
     * @return  DequeIterator<E>(this) this is an iterator for the current deque.
     */
    @Override
    public DequeIterator<E> iterator() {
        return new DequeIterator<E>(this);
    }
    
}