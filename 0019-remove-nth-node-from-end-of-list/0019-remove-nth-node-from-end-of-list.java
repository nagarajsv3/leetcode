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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        int cnt = 0;
        while(cnt<n){
            fast= fast.next;
            cnt++;
        }
        while(fast.next!=null){
            slow= slow.next;
            fast = fast.next;    
        }
        slow.next = slow.next.next;
             
        return dummy.next;
    }
}