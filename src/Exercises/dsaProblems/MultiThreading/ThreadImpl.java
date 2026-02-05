package Exercises.dsaProblems.MultiThreading;

class TestThread extends Thread{
    public void run(){
        System.out.println("runing thread");
    }
}

class Testrunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("using runnable int");
    }
}

public class ThreadImpl {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();

        Testrunnable testrunnable = new Testrunnable();
        Thread thread = new Thread(testrunnable);
        thread.start();

//        ababacabd
//        ab*c*d
    }
}
