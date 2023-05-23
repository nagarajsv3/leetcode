package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.singlenumber;

import java.util.Hashtable;
import java.util.Map;

public class SingleNumberHashTableMain {

    public static void main(String[] args) {

        //int[] numbers = {1, 2, 1, 3, 3, 2, 4};
        int[] numbers = {-1, 2, -1, 3, 3, 2, 4, 4, 99};
        System.out.println("Number="+singleNumber(numbers));

    }

    public static int singleNumber(int[] numbers){
        Map<Integer, Integer> hashTable = new Hashtable<>();

        for (int num: numbers) {
            hashTable.put(num, hashTable.getOrDefault(num, 0)+1);
        }

        for(int num : numbers){
            if (hashTable.get(num) == 1){
                return num ;
            }
        }

        return -1;
    }
}
