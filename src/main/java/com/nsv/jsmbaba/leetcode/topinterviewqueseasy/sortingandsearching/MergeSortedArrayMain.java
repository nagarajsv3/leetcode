package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.sortingandsearching;

public class MergeSortedArrayMain {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int reader1 = m-1;
        int reader2 = n-1;

        for(int writer = (m+n-1) ; writer>=0 ; writer--){

            if(reader1 >= 0 && reader2 >=0){
                nums1[writer] = nums1[reader1] > nums2[reader2] ? nums1[reader1--] : nums2[reader2--];
            }else if(reader1 < 0 && reader2 >=0){
                nums1[writer] = nums2[reader2--];
            }else if(reader1 >= 0 && reader2 < 0){
                nums1[writer] = nums1[reader1--];
            }

        }

    }

}
