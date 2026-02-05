//package Exercises.MultiThreading;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class ErrorHandlingExample {
//
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        // Submit tasks to the ExecutorService
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(1000); // Simulate some task execution
//                System.out.println("Task 1 completed");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Task 1 was interrupted");
//            }
//        });
//
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(2000); // Simulate some task execution
//                throw new RuntimeException("Exception in Task 2");
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Task 2 was interrupted");
//            }
//        });
//
//        // Shut down the ExecutorService
//        executorService.shutdown();
//
//        try {
//            // Wait for all tasks to complete or for a timeout
//            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
//                // If not terminated, forcefully shutdown
//                executorService.shutdownNow();
//                // Wait again
//                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
//                    System.err.println("ExecutorService did not terminate");
//                }
//            }
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//
//        System.out.println("ExecutorService has been shut down");
//    }
//}
