package Exercises.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatilevsAtomic {
    static volatile int s = 0;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger t = new AtomicInteger(0);
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                s++;
                t.incrementAndGet();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println(s+" - "+ t);

        ThreadLocal<Integer> tl = new ThreadLocal<>();
    }
}
