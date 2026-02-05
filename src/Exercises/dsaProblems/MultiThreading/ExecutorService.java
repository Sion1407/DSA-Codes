package Exercises.dsaProblems.MultiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello");
        String s = future.get();
    }
}
