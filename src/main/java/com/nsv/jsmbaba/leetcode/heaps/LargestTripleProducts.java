package com.nsv.jsmbaba.leetcode.heaps;


import java.util.*;

public class LargestTripleProducts {

    int[] findMaxProduct(int[] arr) {
        //Using Priority Queue as MaxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            //Adding to MaxHeap
            maxHeap.offer(arr[i]);

            if (i < 2) {
                output[i] = -1;
            } else {
                //Polling the first maximum
                int num1 = maxHeap.poll();

                //Polling the second maximum
                int num2 = maxHeap.poll();

                //Peeking the third maximum - Just reading the third maximum
                int num3 = maxHeap.peek();

                //Adding first maximum and second maximum
                maxHeap.offer(num1);
                maxHeap.offer(num2);

                output[i] = num1 * num2 * num3;
            }

        }
        return output;
    }


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
        } else {
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
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] arr_1 = {2, 3, 4, 5, 6};
        int[] expected_1 = {-1, -1, 24, 60, 120};
        int[] output_1 = findMaxProduct(arr_1);
        System.out.println("arr_1=" + Arrays.toString(arr_1));
        System.out.println("expected_1=" + Arrays.toString(expected_1));
        System.out.println("output1=" + Arrays.toString(output_1));
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 5, 6, 8, 10};
        int[] expected_2 = {-1, -1, 40, 120, 240, 480};
        int[] output_2 = findMaxProduct(arr_2);
        System.out.println("arr_2=" + Arrays.toString(arr_2));
        System.out.println("expected_2=" + Arrays.toString(expected_2));
        System.out.println("output_2=" + Arrays.toString(output_2));
        check(expected_2, output_2);


    }

    public static void main(String[] args) {
        new LargestTripleProducts().run();
    }

}
