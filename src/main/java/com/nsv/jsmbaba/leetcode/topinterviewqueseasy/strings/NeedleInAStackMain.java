package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.strings;

public class NeedleInAStackMain {

    public static void main(String[] args) {
        System.out.println(strStr("abc","c"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr("happyiamhappy","happy"));

    }

    public static int strStr(String haystack, String needle) {

        if(needle.length() == haystack.length()){
            return needle.equals(haystack) ? 0 : -1;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        int needleLength = needle.length();

        for(int hayPo=0 ;  hayPo < haystack.length() && ((hayPo + needleLength) <= haystack.length()) ; hayPo++){

            String tempStr = haystack.substring(hayPo, hayPo+needleLength);

            if(needle.equals(tempStr)){
                return hayPo;
            }

        }

        return -1;


    }

}
