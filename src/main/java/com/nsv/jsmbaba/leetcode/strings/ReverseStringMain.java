package com.nsv.jsmbaba.leetcode.strings;

public class ReverseStringMain {

    public static void main(String[] args) {
        char[] hello = {'H','e','l','l','o'};
        reverseString(hello);
        System.out.println(hello);

    }

    public static void reverseString(char[] s){

        for (int i=0, j=s.length - 1 ; i< s.length/2 ; i++, j--){
            char fc = s[i];
            s[i] = s[j];
            s[j]= fc;


        }

    }
}
