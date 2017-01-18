
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class Implements Array as a Stack Data Structure.
 * @author Aaron
 * @since September 16, 2014
 */
public class StackA {
    private Integer[] stackarray = new Integer[1000];
    private int place = -1;
    
    /**
     * This method pushes an element onto the stack. It depends on nothing.
     * @param n this is the element to be pushed onto the stack
     */
    public void push(int n){
        place++;
        if(place<stackarray.length){
            stackarray[place] = n;
            }
        else{
            Integer[] temparray = stackarray.clone();
            stackarray = Arrays.copyOf(temparray, (temparray.length)*2);
            stackarray[place] = n;
        }
    }
    
    /**
     * This method pops the top element from the stack. It depends on nothing.
     * @return currentInt this is the integer being stored at the top of the stack
     */
    public Integer pop(){
        int currentInt;
        if(place>((stackarray.length)/4)){
            currentInt = stackarray[place];
            stackarray[place] = 0;
            place--;
            return currentInt;
        }
        else{
            Integer[] temparray = stackarray.clone();
            stackarray = Arrays.copyOf(temparray, (temparray.length)/2);
            currentInt = stackarray[place];
            place--;
            return currentInt;
        }
    }
    
    /**
     * This method returns the element at the top of the stack. It depends on nothing.
     * @return currentInt this is the integer being stored at the top of the stack.
     */
    public Integer peek(){
        int currentInt;
        currentInt = stackarray[place];
        return currentInt;
    }
}
