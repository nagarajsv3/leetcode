package com.nsv.jsmbaba.leetcode.tree.prac1;

public class BinarySearchTreeMain {

    public static void main(String[] args) {

        Tree tree = new Tree();

        System.out.println("********Adding Begin********");
        //Add to tree
        tree.add(25);
        tree.add(10);
        tree.add(4);
        tree.add(30);
        tree.add(60);
        tree.add(70);
        tree.add(1);
        tree.add(90);
        tree.add(2);
        tree.add(6);
        tree.add(5);
        tree.add(7);

        System.out.println("********Adding Completed********");

        System.out.println("********Inorder Traversal Begin********");
        //Traversal - Inorder
        tree.dfsInorderTraversal();
        System.out.println("********Inorder Traversal Completed********");

        System.out.println("********Get Begin********");
        //Get using int input
        System.out.println(tree.get(4));
        System.out.println(tree.get(888));
        System.out.println("********Get Completed********");

        System.out.println("******Min Begin*********");
        System.out.println("Min="+tree.min());
        System.out.println("******Min Completed*********");

        System.out.println("******Max Begin*********");
        System.out.println("Max="+tree.max());
        System.out.println("******Max Completed*********");

        System.out.println("******Delete Leaf Begin*******");
        //tree.deleteworking(90);
        tree.delete2(90);
        tree.dfsInorderTraversal();
        System.out.println("******Delete Leaf Completed*******");

        System.out.println("******Delete 1 Child Parent Begin*******");
        //tree.deleteworking(1);
        tree.delete2(1);
        tree.dfsInorderTraversal();
        System.out.println("******Delete 1 Child Parent Completed*******");

        System.out.println("******Delete 2 children Parent Begin*******");
        //tree.deleteworking(4);
        tree.delete2(4);
        tree.dfsInorderTraversal();
        System.out.println("******Delete 2 children Parent Completed*******");
    }
}
