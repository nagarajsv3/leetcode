package com.nsv.jsmbaba.leetcode.heaps;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for(int each : nums){
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        int j=0;
        while(j<k){
            output[j++] = pq.poll().getKey();
        }
        return output;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1, 1, 2,2,1,3};
        int k=2;

        int[] output = topKFrequentElements.topKFrequent(nums, k);
        System.out.println("Expected [1 , 2]");
        System.out.println("Actual "+ Arrays.toString(output) );


    }
}
