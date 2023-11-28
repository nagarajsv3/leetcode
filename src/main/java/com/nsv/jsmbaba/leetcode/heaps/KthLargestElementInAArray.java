package com.nsv.jsmbaba.leetcode.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : nums){
            maxHeap.offer(num);
        }

        while(k>1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();

        //Time Complexity - O(log n) + O(k * log n) = O(K * log n)
        //Space Complexity - O(n)

    }

    public static void main(String[] args) {
        int nums1[] = {3,2,1,5,6,4};
        int k1 = 2;
        System.out.println("Expected=5 ; Actual="+findKthLargest(nums1, k1));

        int nums2[] = {3,2,3,1,2,4,5,5,6 };
        int k2 = 4;
        System.out.println("Expected=4 ; Actual="+findKthLargest(nums2, k2));


    }


}
