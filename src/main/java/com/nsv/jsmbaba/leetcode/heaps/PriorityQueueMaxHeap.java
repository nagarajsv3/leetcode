package com.nsv.jsmbaba.leetcode.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueMaxHeap {

    public static void main(String[] args) {


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(100);
        maxHeap.offer(200);
        maxHeap.offer(300);
        maxHeap.offer(-400);
        maxHeap.offer(-600);
        maxHeap.offer(600);
        maxHeap.offer(-100);

        System.out.println("Expected peek=600 ; Actual peek="+maxHeap.peek());

        System.out.println("Expected poll=600 ; Actual poll="+maxHeap.poll());

        System.out.println("Expected peek=300 ; Actual peek="+maxHeap.peek());

        maxHeap.offer(-900);
        System.out.println("After adding -900 to pq");
        System.out.println("Expected peek=300 ; Actual peek="+maxHeap.peek());

        System.out.println("Expected isEmpty()=false ; Actual isEmpty)()="+maxHeap.isEmpty());

    }
}
