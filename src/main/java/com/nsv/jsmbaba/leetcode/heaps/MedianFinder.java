package com.nsv.jsmbaba.leetcode.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    public PriorityQueue<Integer> lowerhalfMaxHeap;
    public PriorityQueue<Integer> upperhalfMinHeap;

    public MedianFinder() {
        lowerhalfMaxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder()); //Max Heap
        upperhalfMinHeap = new PriorityQueue<Integer>();  //Min Heap
    }

    public void addNum(int num) {
        lowerhalfMaxHeap.offer(num);

        //Rebalance
        //Lower half should be less than upper half
        if(!lowerhalfMaxHeap.isEmpty() && !upperhalfMinHeap.isEmpty() && lowerhalfMaxHeap.peek() > upperhalfMinHeap.peek()){
            upperhalfMinHeap.offer(lowerhalfMaxHeap.poll());
        }

        //difference of size is 0 or 1 . If it is greater than 1 then rebalance
        if(lowerhalfMaxHeap.size() - upperhalfMinHeap.size() >= 2){
            upperhalfMinHeap.offer(lowerhalfMaxHeap.poll());
        }else if(upperhalfMinHeap.size() - lowerhalfMaxHeap.size() >= 2){
            lowerhalfMaxHeap.offer(upperhalfMinHeap.poll());
        }
    }

    public double findMedian() {
        if(lowerhalfMaxHeap.size() != upperhalfMinHeap.size()){
            if(lowerhalfMaxHeap.size() >  upperhalfMinHeap.size()){
                return lowerhalfMaxHeap.peek();
            }else{
                return upperhalfMinHeap.peek();
            }
        }else{
            double lhmax = lowerhalfMaxHeap.peek();
            double uhmin = upperhalfMinHeap.peek();
            return (lhmax+uhmin)/2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double expected=1.5;
        double actual = medianFinder.findMedian();
        if(actual == expected){
            System.out.println("Test Success "+'\u2713'+" . Median of [1,2] : Expected="+expected+" ; Actual="+actual);
        }else{
            System.out.println("Test Failed "+'\u2717'+" . Median of [1,2] : Expected="+expected+" ; Actual="+actual);
        }

        medianFinder.addNum(3);
        double expected2=2;
        double actual2 = medianFinder.findMedian();
        if(actual == expected){
            System.out.println("Test Success "+'\u2713'+" . Median of [1,2,3] : Expected="+expected2+" ; Actual="+actual2);
        }else{
            System.out.println("Test Failed "+'\u2717'+" . Median of [1,2,3] : Expected="+expected2+" ; Actual="+actual2);
        }




    }


}
