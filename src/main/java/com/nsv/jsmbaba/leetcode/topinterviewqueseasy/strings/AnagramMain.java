package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.strings;

import java.util.Arrays;

public class AnagramMain {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("aacc", "ccac"));
    }

    public static boolean isAnagram(String s, String t) {

        if(s.isEmpty() && t.isEmpty()){
            return true;
        }

        if(s.length()!=t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);

    }
}
