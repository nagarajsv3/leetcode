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
        
        if(list1 == null && list2 != null){
            return list2;
        }else if(list2 == null && list1 != null){
            return list1;
        }else if(list1 == null && list2 == null){
            return list1;
        }
        
        ListNode mergedList = null;
        
        ListNode list1Ref = list1;
        ListNode list2Ref = list2;
        ListNode mergedListRef = mergedList;
        int counter = 0;
        while(list1Ref!=null && list2Ref!=null){
            counter++;
            if(list1Ref.val <= list2Ref.val){
                
                ListNode temp = new ListNode(list1Ref.val);
                System.out.println("temp val="+temp.val+"temp next="+temp.next);
                if(mergedList == null){
                    System.out.println("null Block. Iteration="+counter);
                    mergedList = temp;
                    mergedListRef = mergedList;
                
                }else{
                    System.out.println("Non null Block. Iteration="+counter);
                    mergedListRef.next=temp;
                    mergedListRef = mergedListRef.next;
                }
                
                list1Ref = list1Ref.next;
                
            }else{
                ListNode temp = new ListNode(list2Ref.val);
                System.out.println("temp val="+temp.val+"temp next="+temp.next);
                
                if(mergedList == null){
                    System.out.println("null Block. Iteration="+counter);
                    mergedList = temp;
                    mergedListRef = mergedList;
                }else{
                    System.out.println("Non null Block. Iteration="+counter);
                    mergedListRef.next = temp;
                    mergedListRef = mergedListRef.next;
                }
                
                list2Ref = list2Ref.next;
                
                
            }
            
            System.out.println("mergedListRef.Val="+mergedListRef.val);
            System.out.println("mergedListRef.Next="+mergedListRef.next);
            System.out.println("********************************"+mergedListRef.next);
            
        }
        
        if(list1Ref==null && list2Ref!=null){
            mergedListRef.next = list2Ref ;
        }else if(list2Ref==null && list1Ref != null){
            mergedListRef.next = list1Ref;
        }
        
        return mergedList;
        
    }
}