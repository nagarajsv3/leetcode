package com.nsv.jsmbaba.leetcode.tree.prac1;

public class TreeNode {

    int value;

    TreeNode left;

    TreeNode right;

    //Constructors
    public TreeNode() {

    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }


    //Getters and Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void add(int val) {
        if(value > val){
            //Add to Left Subtree
            if(left == null){
                left = new TreeNode(val);
            }else{
                left.add(val);
            }
        }else{
            //Add to Right Subtree
            if(right == null){
                right = new TreeNode(val);
            }else{
                right.add(val);
            }
        }

    }

    //Left - Node - Right
    public void dfsInorderTraversal() {
        //Left
        if(left != null){
            left.dfsInorderTraversal();
        }

        //Node
        System.out.print(value+" ,");

        //Right
        if(right !=null){
            right.dfsInorderTraversal();
        }
    }

    public boolean get(int i) {
        if(value == i){
            return true;
        }else if(value > i){
            //Search in Left Subtree
            if(left == null){
                return false;
            }else{
                return left.get(i);
            }
        }else{
            //Search in Right Subtree
            if(right == null){
                return false;
            }else{
                return right.get(i);
            }
        }
    }

    public int min() {
        if(left != null){
            return left.min();
        }else{
            return value;
        }
    }

    public int max() {
        if(right != null){
            return right.max();
        }else{
            return value;
        }
    }


}
