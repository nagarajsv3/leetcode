package com.nsv.jsmbaba.leetcode.tree;

public class SortedArrayToBinarySearchTree {

    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }

    TreeNode helper(int low, int high){

        if (low > high) return null;

        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(low, mid-1);
        node.right = helper(mid+1, high);
        return node;
    }
}
