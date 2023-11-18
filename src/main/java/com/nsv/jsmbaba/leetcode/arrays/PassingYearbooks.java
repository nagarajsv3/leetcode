package com.nsv.jsmbaba.leetcode.arrays;

import java.io.IOException;

public class PassingYearbooks {



    int[] findSignatureCounts(int[] arr) {

        int[] signArr = new int[arr.length];

        for(int i=0; i<arr.length; i++){

            sign(signArr);
            boolean goodToProceed = move(arr);

            if(! goodToProceed ){
                return signArr;
            }
        }
        return signArr;
    }


    boolean move(int[] arr){
        int[] copy = new int[arr.length];

        for(int i=0;i<arr.length; i++){
            copy[i] = arr[i];
        }


        for(int j=0;j<copy.length; j++){
            if((j==0)){
                System.out.println("Comparing 1 : "+copy[j-1+ copy.length] +" with "+j);
                if(copy[j-1+ copy.length] == j){
                    arr[j-1+ copy.length] = copy[j];
                    System.out.println("Exit Condition Met : Comparing 1 : "+copy[j-1+ copy.length] +" with "+j);
                    return false;
                }else{
                    arr[j-1+ copy.length] = copy[j];
                }
            } else{
                System.out.println("Comparing 2 : "+copy[j-1] +" with "+j);

                if(copy[j-1] == j){

                    arr[j-1] = copy[j];
                    System.out.println("Exit Condition Met : Comparing 2 : "+copy[j-1] +" with "+j);
                    return false;
                }else{
                    arr[j-1] = copy[j];
                }

            }

        }

        return true;
    }

    void sign(int[] signarr){
        for(int i=0;i<signarr.length; i++){
            signarr[i] = signarr[i]+1;
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
        int[] arr_1 = {2, 1};
        int[] expected_1 = {2, 2};
        int[] output_1 = findSignatureCounts(arr_1);
        check(expected_1, output_1);

        System.out.println("*******************************");

        int[] arr_2 = {1, 2};
        int[] expected_2 = {1, 1};
        int[] output_2 = findSignatureCounts(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new PassingYearbooks().run();
    }
}
