package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.linkedlist;

import java.util.Objects;

public class LinkedListCycleMain {
    public static void main(String[] args) {
        ListNode one = new ListNode(1,null);
        ListNode two = new ListNode(2,null);
        one.next = two;
        System.out.println(hasCycle(one));
    }


    //Flyod's Tortoise and Hare Algorithm is used to solve Cycle with O(1) space complexity
    public static boolean hasCycle(ListNode head) {

        ListNode tortoise = head;
        ListNode hare = head;

        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(tortoise == hare){
                return true;
            }

        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {

            return Objects.hash(val);
        }
    }
}
