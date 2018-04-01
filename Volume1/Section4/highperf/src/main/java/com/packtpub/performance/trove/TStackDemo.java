package com.packtpub.performance.trove;

import gnu.trove.stack.array.TDoubleArrayStack;

public class TStackDemo {
	public static void main(String[] args) {
		final TStackDemo demo = new TStackDemo();
		demo.demonstrateTroveDoubleArrayStack();
	}
	
	/** 
     * Demonstrate Trove's Double Array Stack. 
     * 
     * Trove's TDoubleArrayStack allows access to its 
     * contents via push, pop, and peek. 
     */  
    public void demonstrateTroveDoubleArrayStack()  
    {  
       final TDoubleArrayStack stack = new TDoubleArrayStack();  
       stack.push(15.5);  
       stack.push(17.3);  
       stack.push(16.6);  
       stack.push(2.2);  
       System.out.println("Trove Array Stack of Doubles");  
       System.out.println("\tPeek: " + stack.peek() + "; After Size: " + stack.size());  
       System.out.println("\tPop:  " + stack.pop() + "; After Size: " + stack.size());  
       System.out.println("\tPeek: " + stack.peek() + "; After Size: " + stack.size());  
    }
}
