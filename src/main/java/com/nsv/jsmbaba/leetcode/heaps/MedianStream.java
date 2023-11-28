package com.nsv.jsmbaba.leetcode.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianStream {



    // Add any helper functions you may need here


    int[] findMedian(int[] arr) {
        // Write your code here
        int[] output = new int[arr.length];

        //Max Heap
        PriorityQueue<Integer> lowerhalf = new PriorityQueue<Integer>(Comparator.reverseOrder()); //Max Heap
        //Min Heap
        PriorityQueue<Integer> upperhalf = new PriorityQueue<Integer>(); //Min Heap

        int i=0;
        while(i<arr.length){
            lowerhalf.offer(arr[i]);

            rebalance(lowerhalf, upperhalf);

            int median = calculatemedian(lowerhalf, upperhalf);

            output[i++] = median;
        }
        return output;
    }

    public void rebalance(PriorityQueue<Integer> lowerhalf, PriorityQueue<Integer> upperhalf){
        //Lower Half is always smaller than upper half
        if(!lowerhalf.isEmpty() && !upperhalf.isEmpty() && lowerhalf.peek() > upperhalf.peek()){
            upperhalf.offer(lowerhalf.poll());
        }

        //difference of length is 0 or 1 is ok. >=2 needs rebalancing
        if(lowerhalf.size() - upperhalf.size() >=2 ){
            upperhalf.offer(lowerhalf.poll());
        }else if(upperhalf.size() - lowerhalf.size() >=2 ){
            lowerhalf.offer(upperhalf.poll());
        }

    }


    int calculatemedian(PriorityQueue<Integer> lowerhalf , PriorityQueue<Integer> upperhalf){
        if(lowerhalf.size() > upperhalf.size()){
            return lowerhalf.peek();
        }else if(lowerhalf.size() < upperhalf.size()){
            return upperhalf.peek();
        }else{
            return (lowerhalf.peek()+upperhalf.peek())/2;
        }
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
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MedianStream().run();
    }
}