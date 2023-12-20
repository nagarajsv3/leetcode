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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

//Rec(Left) - Current - Rec(Right)
    void inorderTraversal(TreeNode root, List<Integer> list){
        if(root !=null){
            if(root.left!=null){
                inorderTraversal(root.left, list);
            }

            list.add(root.val);

            if(root.right!=null){
                inorderTraversal(root.right, list);
            }
        }
            
    }
}

