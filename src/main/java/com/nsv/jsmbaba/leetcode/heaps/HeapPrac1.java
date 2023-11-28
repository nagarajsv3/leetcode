package com.nsv.jsmbaba.leetcode.heaps;

public class HeapPrac1 {

    int[] heap;

    int size;

    HeapPrac1(int capacity) {
        this.heap = new int[capacity];
        size = 0;
    }

    int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    int getChildIndex(int index, boolean left) {
        return (2 * index) + (left ? 1 : 2);
    }

    void insert(int val) throws  Exception{
        if(isFull()){
            throw new Exception("Heap is full");
        }

        //Complete BST
        int index = size;
        heap[index] = val;

        //Heapify upwards
        heapifyUpwards(index);

        size++;
    }

    int delete(int index){
        int delval = heap[index];

        //Find the replacement & Delete
        //Complete BST
        heap[index] = heap[size-1];
        heap[size-1] = 0;

        //Heapify upwards or downwards
        if(heap[index] > heap[getParentIndex(index)] ){
            heapifyUpwards(index);
        }else{
            heapifyDownwards(index,size-1);
        }

        size--;
        return delval;
    }

    boolean isEmpty(){
        return size==0;
    }

    boolean isFull(){
        return size==heap.length;
    }

    int peek(){
        if(!isEmpty()){
            return heap[0];
        }
        return Integer.MIN_VALUE;
    }

    void heapifyUpwards(int index){
        int value = heap[index];

        //Identify the index
        while(index > 0 && heap[getParentIndex(index)] < value){
                heap[index] = heap[getParentIndex(index)];
                index = getParentIndex(index);
        }

        heap[index] = value;
    }

    void heapifyDownwards(int index, int lastheapindex){
        int value = heap[index];

        while(index<=lastheapindex){
            int leftChildIndex = getChildIndex(index, true);
            int rightChildIndex = getChildIndex(index, false);
            int replacementChildIndex = 0;
            if(leftChildIndex < lastheapindex){
                if(rightChildIndex > lastheapindex){
                    replacementChildIndex = leftChildIndex;
                }else{
                    replacementChildIndex = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
                }
            }else{
                break;
            }

            //Swap
            if(heap[index] > heap[replacementChildIndex]){
                break;
            }else{
                int temp = heap[index];
                heap[index] = heap[replacementChildIndex];
                heap[replacementChildIndex] = temp;
                index = replacementChildIndex;
            }
        }

    }


    public static void main(String[] args) throws Exception {
        HeapPrac1 heap = new HeapPrac1(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        System.out.println();
        System.out.println("Expected = \n80 , 75 , 60 , 68 , 55 , 40 , 52 , 67 ,");
        printHeap(heap);

        heap.insert(99);

        System.out.println("*****Insert - Heapify upwards demo****");
        System.out.println("Expected = \n99 , 80 , 60 , 75 , 55 , 40 , 52 , 67 , 68 ");
        printHeap(heap);

        System.out.println("******Post Delete 75*******");
        heap.delete(1);
        System.out.println("Expected = \n99 , 75 , 60 , 68 , 55 , 40 , 52 , 67 , ");
        printHeap(heap);
        System.out.println("Expected Peek = 99 ; Peek="+heap.peek());


        System.out.println("******Post Delete 40*******");
        heap.delete(5);
        System.out.println("Expected = \n99 , 75 , 67 , 68 , 55 , 60 , 52 , ");
        printHeap(heap);
        System.out.println("Expected Peek = 99 ; Peek="+heap.peek());

        System.out.println("******Post Delete 80*******");
        heap.delete(0);
        System.out.println("Expected = \n75 , 68 , 67 , 52 , 55 , 60 , ");
        printHeap(heap);
        System.out.println("Expected Peek = 75 ; Peek="+heap.peek());




    }

    private static void printHeap(HeapPrac1 heaps) {

        System.out.println("Heap = ");

        for(int each =0 ; each< heaps.size ; each++){
            System.out.print(heaps.heap[each]+ " , ");
        }
        System.out.println("");
    }


    }
