/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode node) {

        if (node != null){
            if(node.left == null && node.right ==null){
                return 1;
            }
        
            return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;    
                   
        }        
        
        return 0;
    }
}