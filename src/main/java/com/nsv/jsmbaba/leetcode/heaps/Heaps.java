package com.nsv.jsmbaba.leetcode.heaps;

public class Heaps {

    int[] heap;

    int size;

    Heaps(int capacity){
        this.heap = new int[capacity];
        size=0;
    }

    boolean isFull(){
        return size == heap.length;
    }

    void insert(int val) throws Exception {
        if(isFull()){
            throw new Exception("Heap is Full");
        }

        //Complete BST
        heap[size] = val;

        //Heapify
        heapifyUpwards(size);
        size++;
    }

    void delete(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("Heap is Empty");
        }

        //Complete BST
        int deleteval = heap[index];
        heap[index] = heap[size-1];
        heap[size-1] = 0;

        //Heapity
        if(heap[index] <= heap[getParentIndex(index)]){
            heapifyDownwards(index, size-1);
        }else{
            heapifyUpwards(index);
        }

        size--;
    }

    private boolean isEmpty() {
        return size==0;
    }

    private void heapifyUpwards(int index) {
        int val = heap[index];
        while(index> 0 && heap[getParentIndex(index)] < val){
            //Swap Parent and Child element
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }

        heap[index] = val;

    }

    private void heapifyDownwards(int index, int lastHeapIndex) {

        while(index <=lastHeapIndex){
            int leftindex = getChildIndex(index, true);
            int rightindex = getChildIndex(index, false);
            int childindex = 0;
            if(leftindex<=lastHeapIndex){
                if(rightindex>lastHeapIndex){
                    childindex = leftindex;
                }else{
                    childindex = heap[leftindex] > heap[rightindex] ?   leftindex : rightindex;
                }
            }else{
                break;
            }

            if(heap[index] < heap[childindex]){
                int temp = heap[index];
                heap[index] = heap[childindex];
                heap[childindex] = temp;
            }else{
                break;
            }

            index = childindex;
        }
    }

    int getParentIndex(int index){
        return (index-1)/2;
    }

    int getChildIndex(int index, boolean left){
        return 2*index + (left ? 1 : 2);
    }

    int peek(){
        if(!isEmpty()){
            return heap[0];
        }else{
            return Integer.MIN_VALUE;
        }
    }


    public static void main(String[] args) throws Exception {
        Heaps heaps = new Heaps(10);
        heaps.insert(80);
        heaps.insert(75);
        heaps.insert(60);
        heaps.insert(68);
        heaps.insert(55);
        heaps.insert(40);
        heaps.insert(52);
        heaps.insert(67);

        System.out.println();
        System.out.println("Expected = \n80 , 75 , 60 , 68 , 55 , 40 , 52 , 67 ,");
        printHeap(heaps);

        heaps.insert(99);

        System.out.println("*****Insert - Heapify upwards demo****");
        System.out.println("Expected = \n99 , 80 , 60 , 75 , 55 , 40 , 52 , 67 , 68 ");
        printHeap(heaps);

        System.out.println("******Post Delete 75*******");
        heaps.delete(1);
        System.out.println("Expected = \n99 , 75 , 60 , 68 , 55 , 40 , 52 , 67 , ");
        printHeap(heaps);
        System.out.println("Expected Peek = 99 ; Peek="+heaps.peek());


        System.out.println("******Post Delete 40*******");
        heaps.delete(5);
        System.out.println("Expected = \n99 , 75 , 67 , 68 , 55 , 60 , 52 , ");
        printHeap(heaps);
        System.out.println("Expected Peek = 99 ; Peek="+heaps.peek());

        System.out.println("******Post Delete 80*******");
        heaps.delete(0);
        System.out.println("Expected = \n75 , 68 , 67 , 52 , 55 , 60 , ");
        printHeap(heaps);
        System.out.println("Expected Peek = 75 ; Peek="+heaps.peek());




    }

    private static void printHeap(Heaps heaps) {

        System.out.println("Heap = ");

        for(int each =0 ; each< heaps.size ; each++){
            System.out.print(heaps.heap[each]+ " , ");
        }
        System.out.println("");
    }
}
