package Exercises.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(100);
        heap.insert(99);
        heap.insert(75);
        heap.insert(58);
        heap.insert(72);

        heap.insert(81);
        heap.printHeap();

        heap.remove();
        heap.printHeap();

    }
}
