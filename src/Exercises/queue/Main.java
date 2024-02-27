package Exercises.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.printQueue();

        System.out.println("Enqueuing a element in the queue");
        queue.enqueue(2);
        queue.printQueue();

        System.out.println("Dequeuing in queue");
        queue.dequeue();
        queue.printQueue();

    }
}
