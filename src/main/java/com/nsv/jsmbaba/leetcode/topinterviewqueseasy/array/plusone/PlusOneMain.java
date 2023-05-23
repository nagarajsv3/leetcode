package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.plusone;

public class PlusOneMain {

    public static void main(String[] args) {
        int[] digits = {5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9};

        final int[] plusOneInt = plusOne(digits);
        System.out.println("***Print****");
        for (int p: plusOneInt) {
            System.out.println(p);
        }
    }

    public static int[] plusOne(int[] digits) {

        if(digits[digits.length-1] !=9){
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }else {
            StringBuilder sb = new StringBuilder();

            for (int digit : digits) {
                sb.append(digit);
            }

            String strValue = sb.toString();
            System.out.println("Input String="+strValue);
            Long nextValue = Long.parseLong(strValue) + 1;

            String newString = String.valueOf(nextValue);
            System.out.println("Output String="+newString);

            int newArrayLen = newString.length();
            int[] newDigits = new int[newArrayLen];

            for (int i = 0; i < newArrayLen; i++) {
                newDigits[i] =Integer.parseInt(String.valueOf(newString.charAt(i)));
            }

            return newDigits;

        }

    }
}
