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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode();
        ListNode temp = start;
        int sum =0;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry!=0){ //
            sum =0; //init sum to 0
            if(l1 !=null){
                sum = sum + l1.val;
                l1=l1.next;
            }
            
            if(l2 != null){
                sum = sum + l2.val;
                l2=l2.next;
            }
            
            sum = sum + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            if(start.next == null){
                start.next = node;
            }
            
        }
        return start.next;
    }
}