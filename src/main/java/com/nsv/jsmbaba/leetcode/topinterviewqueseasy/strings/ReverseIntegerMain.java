package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.strings;


public class ReverseIntegerMain {

    public static void main(String[] args) {

        int x = 1534236469;
        System.out.println(reverse(x));

        int y = -2147483648;
        System.out.println(reverse(y));

        int z = 123;
        System.out.println(reverse(z));

        int aa = -123;
        System.out.println(reverse(aa));

        int ab = 120;
        System.out.println(reverse(ab));


    }

    public static int reverse(int x) {

        int sign = x >= 0 ? 1 : -1;

        if (Math.abs(Integer.MIN_VALUE) == x) {
            return 0;
        }

        x = Math.abs(x);
        String xval = String.valueOf(x);
        char[] xchars = xval.toCharArray();
        reverse(xchars);
        String revxval = new String(xchars);
        long parsedL = Long.parseLong(revxval);

        if (parsedL > Integer.MAX_VALUE || parsedL < Integer.MIN_VALUE) {
            return 0;
        }

        return sign * (int) parsedL;

    }

    public static void reverse(char[] x) {
        for (int i = 0, j = x.length - 1; i < x.length / 2; i++, j--) {
            char c = x[i];
            x[i] = x[j];
            x[j] = c;
        }

    }

}
