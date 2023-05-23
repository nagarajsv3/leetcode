package com.nsv.jsmbaba.common.fibonacci;

public class FibonacciRecursionMain {

    public static void main(String[] args) {

        int num=10;

        for(int i=1;i<=num;i++){
            int fibNum = fibonacci(i);
            System.out.print(fibNum+" ");
        }


    }

    public static int fibonacci(int num){
        if(num==1 || num==2){
            return 1;
        }

        return  fibonacci(num-1) + fibonacci(num-2);

    }
}
