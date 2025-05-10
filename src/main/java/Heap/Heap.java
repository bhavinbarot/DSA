package Heap;

import java.util.*;

public class Heap {
    private List<Integer> heap;
    public Heap(){
        this.heap = new ArrayList<>();
    }
    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }
    public int leftChild(int index){
        return 2*index + 1;
    }

    public int rightChild(int index){
        return 2*index + 2;
    }

    public int parent(int index){
        return (index-1)/2;
    }
    public void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        //heap.set(heap.size(),value)
        int current = heap.size()-1;
        while(current > 0 && heap.get(current) > heap.get(parent(current))){
                swap(current, parent(current));
                current = parent(current);
        }
    }

    public Integer remove(){
        if(heap.isEmpty()) return null;
        if(heap.size() == 1) return heap.remove(0);

        int maxValue = heap.get(0);

        //Remove the last item in the heap and set it to the root.
        heap.set(0, heap.remove(heap.size()-1));

        //sinkDown
        sinkDown(0);
        return maxValue;

    }

    public void sinkDown(int index){
        int maxIndex = index;
        while(true){
            int leftIndex  = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            if(maxIndex != index){
                swap(index, maxIndex);
                index = maxIndex;
            }else{
                return;
            }
        }

    }


}
