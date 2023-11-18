package com.nsv.jsmbaba.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalMain {

    int level = 0;
    List<List<Integer>> levels = new ArrayList<>();


    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==null){
            return levels;
        }
        return helper(root, level);
    }

    public List<List<Integer>> helper(TreeNode root, int level){
        if(root == null){
            return levels;
        }

        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }


        levels.get(level).add(root.val);

        if(root.left != null){
            helper(root.left, level+1);
        }

        if(root.right != null){
            helper(root.right, level+1);
        }

        return levels;
    }
}
