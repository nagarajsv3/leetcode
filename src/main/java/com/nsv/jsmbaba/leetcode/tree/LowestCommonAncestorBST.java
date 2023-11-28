package com.nsv.jsmbaba.leetcode.tree;

public class LowestCommonAncestorBST {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null){
                return root;
            }

            if(root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left, p, q);
            }else if(root.val < p.val && root.val < q.val){
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;

        }

    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }
    }
}
