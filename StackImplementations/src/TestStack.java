/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Aaron Gaynor
 * @since September 17, 2014
 * The program works as described in the instructions.
 */
public class TestStack {
    
    /**
     * This method times how long it takes to push and pop n elements to and from a stack.
     * It depends on the Stack classes StackA and StackL.
     * @param n This is the amount of Integers to push and pop to the Stack
     * @return timer.durationInSeconds() this is the amount of time it took to run the Stack 
     */
    public static double runStack(int n){
        StackL stack = new StackL();
        ExecutionTimer timer = new ExecutionTimer();
        timer.start();
        for(int i=0; i<n; i++){
            stack.push(i);
        }
        for(int j=0; j<n; j++){
            stack.pop();
        }
        timer.end();
        return timer.durationInSeconds();
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String args[]){
        for(int j=0; j<5; j++){
            for(int i=100000; i<=2000000; i+= 100000){
                double runTime = runStack(i);
                System.out.println(runTime);
            }
            System.out.println("Iteration complete");
        }
    }
}
