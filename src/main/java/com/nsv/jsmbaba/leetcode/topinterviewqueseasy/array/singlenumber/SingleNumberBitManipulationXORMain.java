package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.singlenumber;

public class SingleNumberBitManipulationXORMain {

    public static void main(String[] args) {

        int[] numbers = {1,1,2,3,2,3,4};

        int num = singleNumber(numbers);
        System.out.println("SingleNumber="+num);
    }

    public static int singleNumber(int[] numbers){

        if(numbers.length==1){
            return numbers[0];
        }else{
            int singleNumber=0;
            for(int item : numbers){
                singleNumber = singleNumber ^ item;
            }
            return singleNumber;
        }

    }

}
