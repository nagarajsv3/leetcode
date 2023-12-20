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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root!=null){
          if(root.val == key){
            //Process Delete here
            //Delete Leaf Node
            if(root.left ==null && root.right==null){
                root = null;
                return root;
            }

            //Delete 1 Child Node
            else if(root.left == null && root.right !=null){
                root = root.right;
                return root;
            }else if(root.left !=null && root.right == null){
                root = root.left;
                return root;
            }

            //Delete 2 Children Node
            else{
                int max = max(root.left);
                root.left = deleteNode(root.left, max);
                root.val = max;
                return root;
            }
            
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }else{
            root.right = deleteNode(root.right, key);
            return root;
        }
        }
        return root;
    }

    int max(TreeNode node){
        if(node.right==null){
            return node.val;
        }else{
            return max(node.right);
        }
    }
}