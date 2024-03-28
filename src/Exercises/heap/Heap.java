package Exercises.heap;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap = new ArrayList<>();
    public Heap(){
        this.heap = new ArrayList<>();
    }

    private int leftChild(int index){
        return 2*index+1;
    }
    private int rightChild(int index){
        return 2*index+2;
    }
    private int parent(int index){
        return (index-1)/2;
    }

    private void swap(int idx1,int idx2){
        int temp = heap.get(idx1);
        heap.set(idx1,heap.get(idx2));
        heap.set(idx2,temp);
    }
    public void insert(int value){
        heap.add(value);
        int current = heap.size()-1;
        while (current > 0 && heap.get(current) > heap.get(parent(current))){
            swap(current,parent(current));
            current = parent(current);
        }
    }
    public void printHeap(){
        System.out.println(heap);
    }
}
