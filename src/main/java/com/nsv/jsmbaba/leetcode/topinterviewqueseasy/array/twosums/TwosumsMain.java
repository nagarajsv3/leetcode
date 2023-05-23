package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.twosums;

import java.util.HashMap;
import java.util.Map;

public class TwosumsMain {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 5};
        int target  = 6;

        int[] ints = twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] twosums = new int[2];
        Map<Integer, Integer> itemAndPos = new HashMap<>();

        for(int i=0;i < nums.length ; i++){

            if(itemAndPos.containsKey(target-nums[i])){
                twosums[1] = i;
                twosums[0] = itemAndPos.get(target-nums[i]);
                return twosums;
            }
            itemAndPos.put(nums[i],i);

        }
        return twosums;
    }
}
