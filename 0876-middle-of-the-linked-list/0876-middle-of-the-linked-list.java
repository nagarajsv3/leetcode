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
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
    
        while(fast!=null){
            if(fast.next == null){
                return slow;
            }else if(fast.next.next == null){
                return slow.next;
            }else{
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return null;
    }

    //Time Complexity O(n/2)
    //Space Complexity O(1)
}