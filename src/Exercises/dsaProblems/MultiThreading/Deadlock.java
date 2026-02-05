package Exercises.dsaProblems.MultiThreading;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class DeadlockFree {
//    private final Lock l1 = new ReentrantLock();
//    private final Lock l2 = new ReentrantLock();
//
//    public static void main(String[] args) {
//        DeadlockFree deadlock = new DeadlockFree();
//        new Thread(deadlock::operation1, "T1").start();
//        new Thread(deadlock::operation2, "T2").start();
//    }
//
//    public void operation1() {
//        try {
//            if (l1.tryLock(1, TimeUnit.SECONDS)) {
//                try {
//                    System.out.println("Lock 1 acquired by " + Thread.currentThread().getName());
//                    Thread.sleep(50);
//
//                    if (l2.tryLock(1, TimeUnit.SECONDS)) {
//                        try {
//                            System.out.println("Lock 2 acquired by " + Thread.currentThread().getName());
//                        } finally {
//                            l2.unlock();
//                        }
//                    } else {
//                        System.out.println(Thread.currentThread().getName() + " could not acquire Lock 2, releasing Lock 1");
//                    }
//                } finally {
//                    l1.unlock();
//                }
//            } else {
//                System.out.println(Thread.currentThread().getName() + " could not acquire Lock 1");
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.out.println("Thread was interrupted: " + e.getMessage());
//        }
//    }
//
//    public void operation2() {
//        try {
//            if (l2.tryLock(1, TimeUnit.SECONDS)) {
//                try {
//                    System.out.println("Lock 2 acquired by " + Thread.currentThread().getName());
//                    Thread.sleep(50);
//
//                    if (l1.tryLock(1, TimeUnit.SECONDS)) {
//                        try {
//                            System.out.println("Lock 1 acquired by " + Thread.currentThread().getName());
//                        } finally {
//                            l1.unlock();
//                        }
//                    } else {
//                        System.out.println(Thread.currentThread().getName() + " could not acquire Lock 1, releasing Lock 2");
//                    }
//                } finally {
//                    l2.unlock();
//                }
//            } else {
//                System.out.println(Thread.currentThread().getName() + " could not acquire Lock 2");
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            System.out.println("Thread was interrupted: " + e.getMessage());
//        }
//    }
//}





class Resource {
    String name;
    public Resource(String name) {
        this.name = name;
    }
}

public class Deadlock {
    private final Resource resource1 = new Resource("Resource-1");
    private final Resource resource2 = new Resource("Resource-2");

    public void method1() {
        synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " locked " + resource1.name);

            // Simulating some work
            try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource2.name);
            }
        }
    }

    public void method2() {
        synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + " locked " + resource2.name);

            // Simulating some work
            try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource1.name);
            }
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        Thread t1 = new Thread(deadlock::method1, "Thread-1");
        Thread t2 = new Thread(deadlock::method2, "Thread-2");

        t1.start();
        t2.start();
    }
}
