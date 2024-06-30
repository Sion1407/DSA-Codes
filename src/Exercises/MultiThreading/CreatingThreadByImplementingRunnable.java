package Exercises.MultiThreading;

    class MyThreads1 implements Runnable{
        @Override
        public void run() {
            System.out.println("In Thread1");
        }
    }

    class MyThreads2 implements Runnable{
        @Override
        public void run() {
            System.out.println("In Thread2");
        }
    }
public class CreatingThreadByImplementingRunnable {
    public static void main(String[] args) {
        MyThreads1 myThread1 = new MyThreads1();
        Thread t1 = new Thread(myThread1,"thread1");
        MyThreads2 myThread2 = new MyThreads2();
        Thread t2 = new Thread(myThread2);
        t1.start();
        System.out.println(t1.getName());
        t2.start();
    }
}
