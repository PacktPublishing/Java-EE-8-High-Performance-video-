package com.packtpub.performance.trove;

import java.util.ArrayList;

import gnu.trove.list.array.TDoubleArrayList;

public class TArrayListDemos {

	public static void main(String[] args) {
		final TArrayListDemos demos = new TArrayListDemos();
		demos.demonstrateJdkArrayListForDoubles();
		demos.demonstrateTroveArrayListForDoubles();
	}
	
	  /** 
     * Demonstrate standard JDK {@code ArrayList<Double>} 
     * with some JDK 8 functionality. 
     */  
    public void demonstrateJdkArrayListForDoubles()  
    {  
       final ArrayList<Double> doubles = new ArrayList<>();  
       doubles.add(15.5);  
       doubles.add(24.4);  
       doubles.add(36.3);  
       doubles.add(67.6);  
       doubles.add(10.0);  
       System.out.println("JDK ArrayList<Double>:");  
       System.out.println("\tDoubles List: " + doubles);  
       System.out.println("\tMaximum double: " + doubles.stream().max(Double::compare));  
       System.out.println("\tMinimum double: " + doubles.stream().min(Double::compare));  
       System.out.println("\tSum of doubles: " + doubles.stream().mapToDouble(Double::doubleValue).sum());  
    }  
    /** 
     * Demonstrate use of TDoubleArrayList and show how 
     * similar using it is to using {@code ArrayList<Double>}. 
     */  
    public void demonstrateTroveArrayListForDoubles()  
    {  
       // Demonstrate adding elements to TDoubleArrayList is  
       // exactly like adding elements to ArrayList<Double>.  
       final TDoubleArrayList doubles = new TDoubleArrayList();  
       doubles.add(15.5);  
       doubles.add(24.4);  
       doubles.add(36.3);  
       doubles.add(67.6);  
       doubles.add(10.0);  
       System.out.println("Trove TDoubleArrayList:");  // TDoubleArrayList overrides toString()  
       System.out.println("\tDoubles List: " + doubles);  
       System.out.println("\tMaximum double: " + doubles.max());  
       System.out.println("\tMinimum double: " + doubles.min());  
       System.out.println("\tSum of doubles: " + doubles.sum());  
    }


}
