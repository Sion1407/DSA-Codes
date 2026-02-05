package Exercises.MultiThreading;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ImproveViaMultiThreading {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static Future<String> getUserDetails1(String s){
        return executorService.submit(() -> {
            try {
                Thread.sleep(500);
                return "user";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static Future<String> getUserDetails2(String s){
        return executorService.submit(() -> {
            try {
                Thread.sleep(500);
                return "user2";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> ls = Arrays.asList("user1","user2","user3");
        for (String s : ls){
            String t = getUserDetails1(s).get();
            String t2 = getUserDetails2(s).get();
        }

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

//        List<String> users = Arrays.asList("user1","user2","user3");
//        List<Future<String>> futures = new ArrayList<>();
//
//        for (String s : users) {
//            futures.add(executor.submit(() -> getUserDetails1(s)));
//            futures.add(executor.submit(() -> getUserDetails2(s)));
//        }
//
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }

//        List<String> ls = Arrays.asList("user1","user2","user3");
//
//        List<CompletableFuture<String>> futures = ls.stream()
//                .map(s -> CompletableFuture.supplyAsync(() -> getUserDetails(s), executorService))
//                .toList();
//
//        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();


    }
}
