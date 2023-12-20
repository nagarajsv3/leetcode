import java.lang.*;
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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while(head != null){
            sb.append(head.val);
        
            head = head.next;
        }

        String s = sb.toString();

        for(int i=0, j=s.length()-1 ; i<=j  ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;

    }
}