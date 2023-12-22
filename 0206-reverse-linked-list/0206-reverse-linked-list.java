/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode dummy = null;
        ListNode next = null;
        
        while(head != null){
            //Pre
            next = head.next;
            
            //Process
            head.next = dummy;
            
            //Post
            dummy = head;
            head = next;
        }  
        return dummy;
    }
}