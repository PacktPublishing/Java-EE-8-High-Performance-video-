package com.packtpub.performance.livelock;

/**
 * HostageRescueLivelock.java
 * This class is used to demonstrate livelock situation
 * @author www.codejava.net
 */
public class HostageRescueLivelock {
    static final Police police = new Police();
 
    static final Criminal criminal = new Criminal();
 
    public static void main(String[] args) {
 
 
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                police.giveRansom(criminal);
            }
        });
        t1.setName("Police");
        t1.start();
 
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                criminal.releaseHostage(police);
            }
        });
        t2.setName("Criminal");
        t2.start();
    }
 
}
