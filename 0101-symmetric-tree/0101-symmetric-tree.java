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
    

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    boolean isSymmetricHelper(TreeNode left, TreeNode right){
        
        //Base / Breaking Condition
        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val){
            return false;
        }

        return isSymmetricHelper(left.left, right.right) &&
            isSymmetricHelper(left.right, right.left);

            
    //Time Complexity O(n)
    //Space Complexity O(1)

    }

    

   
}