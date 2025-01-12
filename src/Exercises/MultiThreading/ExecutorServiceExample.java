package Exercises.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintThread implements Runnable{
    private final int taskValue;
    public PrintThread(int taskValue){
        this.taskValue = taskValue;
    }

    @Override
    public void run(){
        System.out.println("taskWithThread " + (taskValue + 1) + " running");
    }
}

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        System.out.println(Thread.currentThread().getName());

//        for (int i = 0; i < 10; i++) {
//            int temp = i;
////            Thread thread = new Thread(() -> System.out.println("taskWithThread " + (temp + 1) + " running"));
//            Thread thread = new Thread(new PrintThread(temp));
//            thread.start();
//        }

        for (int i = 0; i < 10; i++) {
            int temp = i;
            executorService.submit(() -> System.out.println("task" + (temp+1) + " running"));
        }
        executorService.shutdown();

    }
}
