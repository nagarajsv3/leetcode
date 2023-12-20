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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
            return root;
        }else{
            if(root.val > val){
                if(root.left==null){
                    root.left = new TreeNode(val);
                    return root;

                }else{
                    root.left = insertIntoBST(root.left, val);
                    return root;
                }
            }else if(root.val < val){
                if(root.right==null){
                    root.right = new TreeNode(val);
                    return root;
                }else{
                    root.right =  insertIntoBST(root.right, val);
                    return root;
                }
            }
        }
        return root;
    }
}