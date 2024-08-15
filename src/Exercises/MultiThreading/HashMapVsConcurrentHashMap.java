package Exercises.MultiThreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapVsConcurrentHashMap {
        public static void main(String[] args) throws InterruptedException {
            Map<Integer, String> map = new HashMap<>();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    map.put(i, "Value " + i);
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            // Due to race conditions, the size of the map might be less than expected
            System.out.println("Size of HashMap: " + map.size());



            Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

            Runnable tasks = () -> {
                for (int i = 0; i < 1000; i++) {
                    concurrentHashMap.put(i, "Value " + i);
                }
            };

            Thread thread3 = new Thread(tasks);
            Thread thread4 = new Thread(tasks);

            thread3.start();
            thread4.start();

            thread3.join();
            thread4.join();

            // The size of the map should be as expected due to thread-safe operations
            System.out.println("Size of ConcurrentHashMap: " + concurrentHashMap.size());
        }
    }
