package com.packtpub.performance.trove;

import gnu.trove.TCollections;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.list.TIntList;
import gnu.trove.list.linked.TIntLinkedList;
import gnu.trove.list.linked.TLongLinkedList;
import gnu.trove.set.hash.TLongHashSet;

public class TCollectionsDemo {

	public static void main(String[] args) {
		final TCollectionsDemo demo = new TCollectionsDemo();
		System.out.println("Trying to add something to an unmodifiable list");
		demo.demonstrateTroveCollectionsClass();
		System.out.println();
		System.out.println("Demonstrate Iterator");
		demo.demonstrateIterationWithIterator();
		System.out.println();
		System.out.println("Demonstrate Procedure");
		demo.demonstrateIterationWithProcedure();
	}

	/** 
     * Demonstrate one of Trove's "equivalent"s of the 
     * java.util.Collections class. 
     */  
    public void demonstrateTroveCollectionsClass()  
    {  
       final TIntLinkedList integers = new TIntLinkedList();  
       integers.add(5);  
       integers.add(7);  
       integers.add(3);  
       integers.add(1);  
       final TIntList unmodifiableIntegers = TCollections.unmodifiableList(integers);  
       try  
       {  
          unmodifiableIntegers.add(15);  
       }  
       catch (Exception ex)  
       {  
          System.out.println("\tException caught: " + ex);  
       }  
    }
    
	/** 
     * Demonstrate "traditional" iteration of a 
     * Trove collection. 
     */  
    public void demonstrateIterationWithIterator()  
    {  
       final TLongHashSet longs = new TLongHashSet();  
       longs.add(15);  
       longs.add(6);  
       longs.add(12);  
       longs.add(13);  
       longs.add(2);  
       TLongIterator longIterator = longs.iterator();  
       while (longIterator.hasNext())  
       {  
          final long longValue = longIterator.next();  
          System.out.println(longValue);  
       }  
    }
    
    /** 
     * Demonstrate iteration of a Trove collection 
     * using a Procedure. 
     */  
    public void demonstrateIterationWithProcedure()  
    {  
       final TLongLinkedList longs = new TLongLinkedList();  
       longs.add(15);  
       longs.add(6);  
       longs.add(12);  
       longs.add(13);  
       longs.add(2);  
       longs.forEach(new StandardOutputLongProcedure());  
    }
}
