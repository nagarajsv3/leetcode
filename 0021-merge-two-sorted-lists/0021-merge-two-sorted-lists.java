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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {//1 2 4   //1 3 4   1
        if(list1==null && list2==null){ return null;}
        if(list1==null){ return list2;}
        if(list2==null){ return list1;}
        
        ListNode res = null;
        
        if(list1.val <= list2.val){
            res = list1;//1
            
        }else{

            ListNode swp = list1;
                list1 = list2;
                list2 = swp;
            res = list1;
        }
        
        while(list1 !=null && list2 !=null){
            ListNode temp = new ListNode();
            while(list1!=null && list1.val <= list2.val){
                temp = list1; // 1
                list1 = list1.next;
            }
            temp.next = list2;
            
            if(list1!=null){
                ListNode swp = list1;
                list1 = list2;
                list2 = swp;
                            
            }
        }
        return res;
    }
    
    void swap(ListNode list1, ListNode list2){
        ListNode temp = list1;
        list1 = list2;
        list2 = temp;
    }
    
}