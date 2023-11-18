package com.nsv.jsmbaba.leetcode.recursion;

public class FibonacciIterativeMain {
    public static void main(String[] args) {
        int num=10;
        for(int i=1;i<=num;i++){
            int fNum = fibIt(i);
            System.out.print(fNum+" ");
        }
    }

    public static int fibIt(int num){
    if (num ==1 || num==2){
        return 1;
    }

    int fib1=1;
    int fib2=1;
    int fib3=0;

    for(int i=3;i<=num;i++){
        fib3 = fib2 + fib1;
        fib1 = fib2;
        fib2 = fib3;
    }
    return fib3;

    }

}
