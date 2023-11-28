package com.nsv.jsmbaba.leetcode.heaps;

import java.util.PriorityQueue;

public class PriorityQueueMinHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(100);
        pq.offer(200);
        pq.offer(300);
        pq.offer(-400);
        pq.offer(-600);
        pq.offer(600);
        pq.offer(-100);

        System.out.println("Expected peek=-600 ; Actual peek="+pq.peek());

        System.out.println("Expected poll=-600 ; Actual poll="+pq.poll());

        System.out.println("Expected peek=-400 ; Actual peek="+pq.peek());

        pq.offer(-900);
        System.out.println("After adding -900 to pq");
        System.out.println("Expected peek=-900 ; Actual peek="+pq.peek());

        System.out.println("Expected isEmpty()=false ; Actual isEmpty)()="+pq.isEmpty());






    }
}
