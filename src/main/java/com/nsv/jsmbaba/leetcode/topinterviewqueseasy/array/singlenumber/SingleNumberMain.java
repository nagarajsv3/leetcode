package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.singlenumber;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberMain {

    public static void main(String[] args){

        int[] numbers = {1, 2, 1, 3, 3, 2, 4};

        System.out.println("Single Number"+singleNumber(numbers));

        Map<Integer, Integer> itemCountMap = new HashMap<>();

        //iterate through all elements in the array
        for(int i=0; i<numbers.length; i++){
            itemCountMap.put(numbers[i], itemCountMap.getOrDefault(numbers[i],0) + 1);
        }

        System.out.println("Map="+itemCountMap.toString());

        //iterate through map
        Integer singleNumber = null;
        for(Map.Entry<Integer, Integer> entry : itemCountMap.entrySet()){
            if(entry.getValue().intValue()==1){
                singleNumber = entry.getKey();
                System.out.println("Single Number="+singleNumber);
                break;
            }
        }

        //Iterate through keys
        System.out.println("****Iterate through keys");
        for(Integer key : itemCountMap.keySet()){
            System.out.println(key);
        }

        //Iterate through values
        System.out.println("****Iterate through values");
        for(Integer value : itemCountMap.values()){
            System.out.println(value);
        }

        //Iterate through Map.Entry
        System.out.println("****Iterate through Map.Entry");
        for (Map.Entry<Integer, Integer> entry : itemCountMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    public static  int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i=1;i<nums.length;i++)
            result ^= nums[i];
        return result;
    }

}
