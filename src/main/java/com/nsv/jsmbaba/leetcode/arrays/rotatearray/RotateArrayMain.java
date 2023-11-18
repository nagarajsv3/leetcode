package com.nsv.jsmbaba.leetcode.arrays.rotatearray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RotateArrayMain {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k=3;

        rotate(nums,k);
    }


    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverseAnArray(nums, 0, nums.length-1);
        reverseAnArray(nums, 0, k-1);
        reverseAnArray(nums, k, nums.length-1);

        System.out.println(Arrays.toString(nums));

    }


    public static void reverseAnArray(int[] nums, int startPos, int endPos){
        while(startPos < endPos){
            int temp = nums[endPos];
            nums[endPos] = nums[startPos];
            nums[startPos] = temp;
            startPos++;
            endPos--;
        }
    }


}
