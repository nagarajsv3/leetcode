package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.plusone;

import java.util.Arrays;

public class PlusOneMain {

    public static void main(String[] args) {
        int[] input1 = {5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9};
        System.out.println(Arrays.toString(input1));
        int[] output1 = plusOne(input1);
        System.out.println(Arrays.toString(output1));

        int[] input2 = {1,2,3};
        System.out.println(Arrays.toString(input2));
        int[] output2 = plusOne(input2);
        System.out.println(Arrays.toString(output2));

        int[] input3 = {9,9,9,9,9};
        System.out.println(Arrays.toString(input3));
        int[] output3 = plusOne(input3);
        System.out.println(Arrays.toString(output3));

        int[] input4 = {3,5,9,9,9};
        System.out.println(Arrays.toString(input4));
        int[] output4 = plusOne(input4);
        System.out.println(Arrays.toString(output4));

    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        if(digits[len-1] != 9){
            digits[len-1] = digits[len-1] + 1;
            return digits;
        }else{

            for(int i = len-1 ; i>=0 ; i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                }else{
                    digits[i] = digits[i] + 1;
                    return digits;
                }
            }

            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;

        }


    }
}
