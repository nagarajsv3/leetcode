package com.nsv.jsmbaba.leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {3,-1,-3,-4,10,5,8,6,4,78,98,105,140};
        int k=3;
        int[] output = maxSlidingWindow(nums, k);
        for(int each : output){
            System.out.println(each);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        int outputLn = 0;

        if(k==1){
            outputLn = nums.length;
        }else{
            outputLn = nums.length-k+1;
        }

        int[] output = new int[outputLn];

        for(int i=0; i<nums.length; i++){

            //Removing Out Of Bound Indexes from Front
            if(! deque.isEmpty() && deque.peek() == (i-k)){
                deque.poll();
            }

            //Removing Smaller Element Indexes from Back
            while(! deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            //Add index to Deque
            deque.offer(i);

            //Writing to output
            if(i >= k-1){
                output[i-(k-1)] = nums[deque.peek()];
            }

        }

        return output;

    }
}
