package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.tree.prac1;

public class Tree {

    private TreeNode root;


    //Constructors///////////////////////
    public Tree() {

    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    //Getters and Setters///////////////////////

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    //Methods///////////////////////

    public void add(int value){
        if(root == null){
            root = new TreeNode(value);
        }else{
            root.add(value);
        }
    }

    public void dfsInorderTraversal() {
        if (root != null){
            root.dfsInorderTraversal();
        }else{
            System.out.println("Null");
        }
    }

    public boolean get(int i) {
        if(root == null){
            return false;
        }else{
            return root.get(i);
        }
    }

    public int min() {
        if(root == null){
            return Integer.MIN_VALUE;
        }else{
            return root.min();
        }
    }

    public int max() {
        if(root == null){
            return Integer.MAX_VALUE;
        }else{
            return root.max();
        }
    }

    public void deleteworking(int i) {

        if(root!=null){
            root = getReplacementNodePostDeleteworking(root, i);
        }
    }

    private TreeNode getReplacementNodePostDeleteworking(TreeNode subTree, int i) {
        if(subTree == null){
            return null;
        }else{
            if(subTree.getValue() == i){
                //Delete Leaf Node
                if(subTree.getLeft() == null && subTree.getRight() == null){
                    return null;
                }

                //Delete 1 Child Node
                else if(subTree.getLeft() == null && subTree.getRight() != null){
                    return subTree.getRight();
                }

                else if(subTree.getLeft() != null && subTree.getRight() == null){
                    return subTree.getLeft();
                }
                //Delete 2 Children Node

                else{
                    //Get Min from Right Subtree
                    int minFromRightSubTree = subTree.getRight().min();
                    subTree.setValue(minFromRightSubTree);

                    subTree.setRight(getReplacementNodePostDeleteworking(subTree.getRight(), minFromRightSubTree ));
                    return subTree;

                }
            }else{
                if(i > subTree.getValue()){
                    //Right Side Recursive delete
                    subTree.setRight(getReplacementNodePostDeleteworking(subTree.getRight(),i));
                    return subTree;
                }else{
                    //Left Side Recursive delete
                    subTree.setLeft(getReplacementNodePostDeleteworking(subTree.getLeft(),i));
                    return subTree;
                }
            }
        }

    }


    public void delete2(int i) {
        if(root!=null){
            root = getReplacementNodePostDelete(root, i);
        }
    }

    private TreeNode getReplacementNodePostDelete(TreeNode subtree, int i) {
        if(subtree == null){
            return null;
        }else{
            if(subtree.getValue() == i){
                //Go Ahead and Delete based on condition
                //Delete - Leaf
                if(subtree.getLeft()==null && subtree.getRight()==null){
                    return null;
                }
                //Delete - 1 Child
                else if(subtree.getLeft()==null && subtree.getRight()!=null){
                    return subtree.getRight();
                }
                //Delete - 1 Child
                else if(subtree.getLeft()!=null && subtree.getRight()==null){
                    return subtree.getLeft();
                }
                //Delete - 2 Children Node
                else{
                    //Get Min from Right Subtree
                    int minFromRightSubtree = subtree.getRight().min();
                    subtree.setValue(minFromRightSubtree);

                    subtree.setRight(getReplacementNodePostDelete(subtree.getRight(), minFromRightSubtree));
                    return subtree;
                }

            }else{
                if(subtree.getValue() > i){
                    //Left Subtree
                    subtree.setLeft(getReplacementNodePostDelete(subtree.getLeft(),i));
                    return subtree;
                }else{
                    //Right Subtree
                    subtree.setRight(getReplacementNodePostDelete(subtree.getRight(), i));
                    return subtree;
                }
            }

        }
    }
}
