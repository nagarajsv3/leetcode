package com.nsv.jsmbaba.leetcode.tree;

public class LowestCommonAncestor {


    TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q){
        if(root==null || root == p || root == q){
            return root;
        }

        TreeNode2 left = lowestCommonAncestor(root.left, p, q);
        TreeNode2 right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }else if(right ==null){
            return left;
        }else{
            return root;
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}


