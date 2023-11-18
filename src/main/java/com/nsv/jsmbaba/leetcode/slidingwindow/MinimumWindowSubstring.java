package com.nsv.jsmbaba.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {

        if(s.isEmpty() || t.isEmpty() || (t.length() > s.length())){
            return "";
        }

        if(s.equals(t)){
            return t;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char tch = t.charAt(i);
            map.put(tch, map.getOrDefault(tch,0) + 1);
        }
        int count = map.size();

        int i = 0;
        int j = 0;

        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        boolean found = false;

        //Acquire Substring which has all chars
        while( j < s.length()){
            char sch = s.charAt(j);
            j++;

            if(map.containsKey(sch)){
                map.put(sch, map.get(sch) - 1);
                if(map.get(sch) == 0){
                    count -- ;
                }

                if(count > 0){
                    continue;
                }

                //Shorten the substring which has all chars
                while(i < s.length() && count == 0){
                    found= true;
                    char ich =s.charAt(i);
                    i++;

                    if(map.containsKey(ich)){
                        map.put(ich, map.get(ich)+1);
                        if(map.get(ich) > 0){
                            count++;
                        }
                    }
                }

                if(min > (j-i)){
                    found =true;
                    min = j-i;
                    left = i-1;
                    right = j-1;
                }
            }
        }
        return !found ? "": s.substring(left, right+1);

    }
}
