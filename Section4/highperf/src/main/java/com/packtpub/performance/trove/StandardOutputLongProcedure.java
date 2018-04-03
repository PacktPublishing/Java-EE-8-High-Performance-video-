package com.packtpub.performance.trove;

import static java.lang.System.out;  
import gnu.trove.procedure.TLongProcedure;  
/** 
 * Simple implementation of TLongProcedure that 
 * iterates over Trove collection of {@code long} 
 * values and writes those values to standard 
 * output with one value per line. 
 */  
public class StandardOutputLongProcedure implements TLongProcedure  
{  
   @Override  
   public boolean execute(long longValue)  
   {  
      out.println(longValue);  
      return true;  
   }  
}