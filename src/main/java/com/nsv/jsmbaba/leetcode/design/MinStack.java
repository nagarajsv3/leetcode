package com.nsv.jsmbaba.leetcode.design;

import java.util.Stack;

public class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
        }else{
            int currmin = getMin() ;
            stack.push(new int[]{val, currmin > val ? val : currmin });
        }
    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        int[] peeked = stack.peek();
        return peeked[0];
    }

    public int getMin() {
        int[] peeked = stack.peek();
        return peeked[1];
    }


}
