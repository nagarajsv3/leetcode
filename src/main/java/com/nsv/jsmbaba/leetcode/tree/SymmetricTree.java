package com.nsv.jsmbaba.leetcode.tree;

public class SymmetricTree {

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
        //Space Complexity O(log n) - uses stack

    }
}
