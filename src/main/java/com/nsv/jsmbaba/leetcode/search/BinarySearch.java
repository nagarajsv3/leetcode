package com.nsv.jsmbaba.leetcode.search;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    int binarySearch(int[] nums, int target, int left, int right){
        if(left > right){
            return -1;
        }

        int mid = left + (right-left)/2;

        if(nums[mid] == target ){
            return mid;
        }else if (nums[mid] < target){
            return binarySearch(nums, target, mid+1, right);
        }else{
            return binarySearch(nums, target, left, mid-1);
        }

    }

    public static void main(String[] args) {
        new BinarySearch().run();
    }

    private void run() {
        String testcase1 = "Test Case 1";
        int[] input1 = {-1,0,3,5,9,12};
        int target1 = 9;
        int expectedOutput1 =  4;
        int actualOutput1 = search(input1, target1);
        check(testcase1 , expectedOutput1 , actualOutput1);

        String testcase2 = "Test Case 2";
        int[] input2 = {-1,0,3,5,9,12};
        int target2 = 2;
        int expectedOutput2 =  -1;
        int actualOutput2 = search(input2, target2);
        check(testcase2 , expectedOutput2 , actualOutput2);
    }

    private void check(String testcase, int expectedOutput1, int actualOutput1) {
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if(expectedOutput1 != actualOutput1){
            System.out.println(testcase+" "+wrongTick);
        }else{
            System.out.println(testcase+" "+rightTick);
        }
    }



}
