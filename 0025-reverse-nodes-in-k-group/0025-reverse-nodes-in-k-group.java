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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode nex = dummy;
        
        int cnt = 0;
        while(cur.next!=null){
            cnt++;
            cur = cur.next;
        }
        
        while(cnt >= k){
            cur = pre.next;
            nex = cur.next;
                for(int i=1; i<k ; i++){
                    cur.next = nex.next;
                    nex.next = pre.next;
                    pre.next = nex;
                    nex = cur.next;
                }    
            pre = cur;
            cnt -= k;
        }
        return dummy.next;
    }
}