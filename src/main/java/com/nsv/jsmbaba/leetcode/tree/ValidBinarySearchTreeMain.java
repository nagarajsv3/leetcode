package com.nsv.jsmbaba.leetcode.tree;

public class ValidBinarySearchTreeMain {

    Integer previous = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    boolean inorder(TreeNode subtree){

        if(subtree != null){
            if(!(inorder(subtree.left))){
                return false;
            }

            if(previous != null && previous >= subtree.val){
                return false;
            }

            previous = subtree.val;

            return inorder(subtree.right);

        }else{
            return true;
        }



    }

}