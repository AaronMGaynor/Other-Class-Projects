
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class iterates through a deque.
 * @author Aaron Gaynor
 * @since September 3, 2014
 */
public class DequeIterator<E> implements Iterator<E> {
    Deque<E> deque;

    public DequeIterator() {
    }
    
    public DequeIterator(Deque<E> deque){
        this.deque = deque;
    }
    
    
    /**
     * This method returns a boolean value indicating whether or not you have reached
     * the end of the deque.
     * @return 
     */
    @Override
    public boolean hasNext() {
        if(this.deque.getLength() > 0){
            return true;
        }
        else{
            return false;
        }
        
    }

    /**
     * This method returns the element stored in the next Node and cycles forward one through the deque.
     * @return element this is the element in the next node.
     */
    @Override
    public E next() {
        if(deque.getLength() > 0){
            E element = this.deque.removeFirst();
            return element;
        }
        else{
            return null;
        }
    }

    /**
     * This method removes the first node in the deque.
     */
    @Override
    public void remove() {
        this.deque.removeFirst();
    }
    
}
