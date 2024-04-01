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

    public Integer remove(){
        if (heap.size()==0) return null;

        if (heap.size()==1) return heap.remove(0);

        int maxValue = heap.get(0);

        heap.set(0,heap.remove(heap.size()-1));

        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int indx){
        int maxIdx = indx;
        while (true){
            int leftIdx = leftChild(maxIdx);
            int rightIdx = rightChild(maxIdx);
            if (leftIdx < heap.size() && heap.get(leftIdx) > heap.get(maxIdx)){
                maxIdx = leftIdx;
            }
            if (rightIdx < heap.size() && heap.get(rightIdx) > heap.get(maxIdx)){
                maxIdx = rightIdx;
            }
            if (maxIdx != indx){
                swap(indx,maxIdx);
                indx = maxIdx;
            }
            else {
                return;
            }
        }
    }
}
