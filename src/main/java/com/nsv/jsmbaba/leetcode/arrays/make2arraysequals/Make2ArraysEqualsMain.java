package com.nsv.jsmbaba.leetcode.arrays.make2arraysequals;

import java.util.Arrays;

public class Make2ArraysEqualsMain {

    public boolean canBeEqual(int[] target, int[] arr) {


        if(target.length != arr.length){
            return false;
        }

        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i=0;i<target.length; i++){
            if(target[i] !=arr[i]){
                return false;
            }
        }

        return true;
    }

    public void run(){
        int[] a = {1,3,2,4};
        int[] b = {3,1,2,4};
        boolean output = canBeEqual(a,b);
        check(output, true);

        int[] a2 = {1,3,2,4};
        int[] b2 = {3,1,2,5};
        boolean output2 = canBeEqual(a2,b2);
        check(output2, false);


    }

    private void check(boolean output, boolean expected) {
        char pass = '\u2713';
        char fail = '\u2717';
        char result = output==expected ? pass : fail;
        System.out.println("Test Expected="+expected+" ;Actual="+output+" ;Final Test Status="+result);
    }

    public static void main(String[] args) {

        new Make2ArraysEqualsMain().run();

    }
}
