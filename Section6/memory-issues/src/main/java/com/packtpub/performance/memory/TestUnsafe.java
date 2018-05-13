package com.packtpub.performance.memory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class TestUnsafe {

    public static void main(String[] args) throws Exception{
        @SuppressWarnings("rawtypes")
		final Class unsafeClass = Class.forName("sun.misc.Unsafe");
        final Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        @SuppressWarnings("restriction")
		final Unsafe unsafe = (Unsafe) f.get(null);
        System.out.print("4..3..2..1...");
        try
        {
            for(;;)
                unsafe.allocateMemory(1024*1024);
        } catch(Error e) {
            System.out.println("Boom :)");
            e.printStackTrace();
        }
    }

}