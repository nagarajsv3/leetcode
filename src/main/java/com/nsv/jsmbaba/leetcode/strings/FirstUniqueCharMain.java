package com.nsv.jsmbaba.leetcode.strings;


import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharMain {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("loveleetcode"));
        System.out.println(firstUniqueChar("aabb"));

    }

    public static int firstUniqueChar(String s){

        Map<Character, Boolean> map = new HashMap<>();
        for(int i = 0; i<=s.length()-1; i++){
            char firstCh = s.charAt(i);


            if(!map.containsKey(firstCh)){

                boolean duplicate = false;
                for(int j=i+1; j<=s.length()-1;j++){
                    char secondCh= s.charAt(j);

                    if(firstCh == secondCh){
                        map.put(firstCh, true);
                        duplicate = true;
                        break;
                    }
                }

                if(duplicate == false){
                    return i;
                }

            }

        }

        return -1;
    }
}
