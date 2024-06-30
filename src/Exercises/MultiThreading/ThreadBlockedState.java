package Exercises.MultiThreading;

public class ThreadBlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable());
        Thread t2 = new Thread(new DemoBlockedRunnable());

        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(t2.getState());
        System.exit(0);
    }

}
class DemoBlockedRunnable implements Runnable{
    @Override
    public void run(){
        commmonResource();
    }
//    static will allow only 1 thread to execute
    public static synchronized void commmonResource(){
        while (true){

        }
    }

}
