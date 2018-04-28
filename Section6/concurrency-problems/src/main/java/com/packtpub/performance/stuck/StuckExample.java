package com.packtpub.performance.stuck;

/**
 * StuckExample.java
 * This class is used to demonstrate starvation situation.
 * @author keilw
 */
public class StuckExample {
 
    public static void main(String[] args) {
        Worker worker = new Worker();
 
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    worker.work();
                }
            }).start();
        }
    }
}