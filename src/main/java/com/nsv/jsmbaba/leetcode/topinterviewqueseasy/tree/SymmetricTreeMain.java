package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.tree;

public class SymmetricTreeMain {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if((left == null && right == null)){
            return true;
        }

        if((left == null) || (right==null)){
            return false;
        }

        return left.val == right.val &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);


    }
}
