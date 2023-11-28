package com.nsv.jsmbaba.leetcode.queue;

import java.util.*;

public class QueueRemovals {

    class Item{
        public int value;
        public int index;
        Item(int value, int index){
            this.value = value;
            this.index=index;
        }
    }

    // Add any helper functions you may need here


    int[] findPositions(int[] arr, int x) {
        // Write your code here
        Queue<Item> itemQ = new ArrayDeque<>();
        populateItemQ(arr, itemQ);

        Queue<Integer> outputQ = new ArrayDeque<>();

        int numberOfIterations = x;

        while(x >=0){

            Item max = new Item(-100, -1);
            List<Item> items = new ArrayList<>();

            int maxNumberOfPolls = Math.min(numberOfIterations, itemQ.size());

            for(int i=0; i<maxNumberOfPolls ; i++){
                Item poppedItem = itemQ.poll();
                System.out.println("Popped Item Value="+poppedItem.value+";Index="+poppedItem.index);
                items.add(poppedItem);
                if(max.value < poppedItem.value){
                    max = new Item(poppedItem.value , poppedItem.index);
                }
            }

            //Add Index
            postPollProcessing(max, itemQ, outputQ,items);

            x--;
        }

        return getOutputArray(outputQ);
    }

    void postPollProcessing(Item max, Queue<Item> itemQ, Queue<Integer> outputQ, List<Item> items){
        outputQ.offer(max.index);
        Iterator<Item>  it = items.iterator();
        while(it.hasNext()){
            Item fetchedItem = it.next();
            if(fetchedItem.index == max.index){
                it.remove();
            }else{
                fetchedItem.value = fetchedItem.value == 0 ? 0 : fetchedItem.value -1 ;
                itemQ.offer(fetchedItem);
            }
        }
    }

    int[] getOutputArray(Queue<Integer> outputQ){
        int[] output = new int[outputQ.size()];
        int k=0;

        while(!outputQ.isEmpty()){
            output[k] = outputQ.poll();
            k++;
        }
        return output;
    }

    void populateItemQ(int[] arr, Queue<Item> itemQ){
        for(int i=0;i<arr.length; i++){
            Item item = new Item(arr[i], i);
            itemQ.offer(item);
        }
        System.out.println("ItemQ Size"+itemQ.size());
    }















    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int n_1 = 6;
        int x_1 = 5;
        int[] arr_1 = {1, 2, 2, 3, 4, 5};
        int[] expected_1 = {5, 6, 4, 1, 2 };
        int[] output_1 = findPositions(arr_1, x_1);
        check(expected_1, output_1);

        int n_2 = 13;
        int x_2 = 4;
        int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] expected_2 = {2, 5, 10, 13};
        int[] output_2 = findPositions(arr_2, x_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new QueueRemovals().run();
    }
}