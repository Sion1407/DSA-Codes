package Exercises.MultiThreading;

public class CreatingThreadByExtendingThreadClass {
    public static void main(String[] args) {
       MyThread1 myThread1 = new MyThread1();
       MyThread2 myThread2 = new MyThread2();
//       default 5
       myThread1.setPriority(1);
        myThread2.setPriority(Thread.MAX_PRIORITY);
       myThread1.start();
       myThread2.start();

//    creating threds using lambda expressions:
//        Runnable myThread = () ->
//        {
//            // Used to set custom name to the current thread
//            Thread.currentThread().setName("myThread3");
//            System.out.println(
//                    Thread.currentThread().getName()
//                            + " is running");
//        };
//        Thread run = new Thread(myThread);
//        run.start();
    }

}

class MyThread1 extends Thread{
    @Override
       public void run(){
        int i = 0;
        while (i<4000) {
            System.out.println("Thread1 is running");
            i++;
        }
       }
}
class MyThread2 extends Thread{
    @Override
       public void run(){
        int i = 0;
        while (i<4000){
            System.out.println("Thread2 is running");
            i++;
        }
       }
}
