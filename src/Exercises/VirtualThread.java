package Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        List<String> lst = Arrays.asList("a","b","c");
        List<Future<String>> futures = lst.stream().map(s -> executorService.submit(() -> {
            System.out.println("Running " + s + " in thread: " + Thread.currentThread());
            return s;
        })).toList();
        for (Future f : futures){
            System.out.println(f.get());
        }

        Thread t1 = Thread.startVirtualThread(() -> {

        });
        String s = "Sion";
        String msg = STR."Hello \{s}";
        System.out.println(msg);
        ScopedValue<String> USER = ScopedValue.newInstance();
        ScopedValue.where(USER, msg).run(() -> System.out.println(""));
        System.out.println(USER.get());
    }
}
