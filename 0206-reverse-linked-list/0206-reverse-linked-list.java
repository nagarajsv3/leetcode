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
    
    
}