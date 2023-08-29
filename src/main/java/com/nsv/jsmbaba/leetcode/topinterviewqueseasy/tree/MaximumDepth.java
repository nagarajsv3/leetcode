package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.tree;

public class MaximumDepth {

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
