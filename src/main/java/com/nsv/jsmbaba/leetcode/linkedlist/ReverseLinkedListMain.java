package com.nsv.jsmbaba.leetcode.linkedlist;

public class ReverseLinkedListMain {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        System.out.println(head);
        head = reverseList(head);
        System.out.println("******************************88");
        System.out.println(head);

    }


        public static ListNode reverseList(ListNode head) {

            if(head == null){
                return head;
            }

            ListNode previousNodeRef = null;
            ListNode nextNodeRef = null;
            ListNode currentProcessingNodeRef = head;

            while(currentProcessingNodeRef != null){
                //Things Needed for Next Processing
                nextNodeRef = currentProcessingNodeRef.next;

                //Processing
                currentProcessingNodeRef = new ListNode(currentProcessingNodeRef.val, previousNodeRef);

                //Post Processing
                previousNodeRef = currentProcessingNodeRef;
                currentProcessingNodeRef = nextNodeRef;


            }

            return previousNodeRef;

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
    }
}
