package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.containsduplicate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateMain {

    public static void main(String[] args) {

        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));

        int[] nums2={1,2,3,4};
        System.out.println(containsDuplicate(nums2));

    }

    public static boolean containsDuplicate(int[] nums) {

        boolean duplicatePresent = false;

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int num : nums){
            if(numMap.get(num) != null){
                duplicatePresent = true;
                break;
            }else{
                numMap.put(num,num);
            }
        }

        return duplicatePresent;

    }
}
