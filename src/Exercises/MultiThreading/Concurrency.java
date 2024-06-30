package Exercises.MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

class LockExample{
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment(){
//        This call acquires the lock before entering the critical section. If another thread already holds the lock,
//        the current thread will wait until the lock is available.
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }
    }
    public int getCounter(){
        return  count;
    }

}

public class Concurrency {
    public static void main(String[] args) throws InterruptedException {
        LockExample lockExample = new LockExample();
        Runnable task = ()->{
            for (int i = 0; i < 1000; i++) {
                lockExample.increment();
            }  
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();thread2.start();
//        join() will make the main thread to wait till t1 and t2 completes its execution
        thread1.join();thread2.join();
        System.out.println("counter"+ lockExample.getCounter() );
    }
}
