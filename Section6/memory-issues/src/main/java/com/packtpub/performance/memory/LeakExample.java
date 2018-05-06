package com.packtpub.performance.memory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author frank
 * @author werner
 */
public class LeakExample {

    static List<String> alist = new ArrayList<>();
    public void offByOneList(int count) {

        for (int n = 0; n < count; n++) {
            alist.add(new Date().toString());
            System.out.println("adding element " + n );
        }

        // tpyical one off C style programming error
        // should be n>=0, here element 0 is missed!
        for (int n = count - 1; n > 0; n--) {
            System.out.println("remvoing element " + n);
            alist.remove(n);
        }
        // ergo better use Java 5 style iterator() with hasNext()!

    }

    public static void main(String[] args) {
        LeakExample leak = new LeakExample();

        while (true) leak.offByOneList(42);

    }
}
