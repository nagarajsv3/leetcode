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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null && list2==null) return null;
        if(list1 ==null && list2 !=null ) return list2;
        if(list1 !=null && list2 == null) return list1;
        
        if(list1.val > list2.val){
                ListNode t = list1;
                list1 = list2;
                list2 = t;
        }
        ListNode ref = list1;
        
        ListNode smallest = null;
        while(list1!=null && list2 !=null){
            System.out.println("Outer : list1="+list1.val+" list2="+list2.val);
            while(list1!=null && list1.val <=list2.val){
                System.out.println("Inner : list1="+list1.val+" list2="+list2.val);
                smallest = list1;
                list1 = list1.next;
            }    
            smallest.next = list2;
            if(list1!=null){
                ListNode t = list1;
                list1 = list2;
                list2 = t;
            }
        }
        return ref;
    }
}