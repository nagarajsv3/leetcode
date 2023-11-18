package com.nsv.jsmbaba.leetcode.arrays.singlenumber;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberMainP {


    public static void main(String[] args) {
int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
