package com.nsv.jsmbaba.leetcode.arrays.movezeroes;

import java.util.Arrays;

public class MoveZeroesMain {


    public static void main(String[] args) {
        int[] input1 = {0,12,1,2,0};
        System.out.println(Arrays.toString(input1));
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));


        int[] input2 = {0,0,1};
        System.out.println(Arrays.toString(input2));
        moveZeroes(input2);
        System.out.println(Arrays.toString(input2));

    }
    public static void moveZeroes(int[] nums) {
        int len = nums.length ;

        if(len == 1){

        }else{
            int zeroPos = nums.length-1;
            for(int i=0, j=0; i<(len) && i< zeroPos && j<=len  ; j++){
                int item= nums[i];
                if(item == 0){
                    shiftLeft(nums, i,zeroPos);
                    zeroPos--;
                }else{
                    i++;
                }
            }
        }


    }

    public static void shiftLeft(int[] nums, int begPos, int endPos){
        int tempVal = nums[begPos];

        for(int i = begPos; i< nums.length-1  ; i++){
            nums[i] = nums[i+1];

            if (i==endPos ){
                break;
            }
        }

        nums[nums.length-1] = tempVal;

    }
}
