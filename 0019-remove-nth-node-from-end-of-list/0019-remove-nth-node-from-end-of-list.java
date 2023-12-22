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
        int size = 0;
        ListNode dummy = head;
        while(dummy != null){
            size++;
            dummy = dummy.next;
        }
        
        int nodedel = size-n;
        
        int nodedelcnt = 0;
        ListNode del = head;
        while(del!=null){
            nodedelcnt++;
            
            if(nodedel==0){
                del= del.next;
                return del;
            }else if(nodedelcnt == nodedel){
                del.next = del.next.next;
                break;
            }else{
                del = del.next;
            }
            
        }
        return head;
    }
}