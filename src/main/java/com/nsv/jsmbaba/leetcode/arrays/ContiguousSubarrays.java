package com.nsv.jsmbaba.leetcode.arrays;

import java.util.Stack;

public class ContiguousSubarrays {


    int[] countSubarrays(int[] arr) {
        // Write your code here

        int[] count = new int[arr.length];
        iterateForward(arr, count);
        iterateBackward(arr, count);
        return count;

    }

    void iterateForward(int[] arr, int[] count){
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                count[i] = count[i]+1;
            }else{

                while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                    int idx = stack.pop();
                    count[i] = count[i] + count[idx];
                }

                stack.push(i);
                count[i] = count[i]+1;
            }

        }

        print(count);

    }

    void iterateBackward(int[] arr, int[] count){
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[arr.length];

        for(int i=arr.length-1 ; i>=0; i--){
            if(stack.isEmpty()){
                stack.push(i);
                temp[i] = temp[i] + 1;
            }else{
                while(! stack.isEmpty() && arr[i] > arr[stack.peek()]){
                    int idx = stack.pop();
                    temp[i] = temp[i]+temp[idx];

                }

                stack.push(i);
                temp[i] = temp[i]+1;


            }

            count[i] = count[i]+ temp[i] - 1;
        }

        print(count);

    }


    void print(int[] arr){
        for(int each : arr ){
            System.out.print(each +" " );
        }
        System.out.println();

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
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new ContiguousSubarrays().run();
    }
}
