package com.nsv.jsmbaba.leetcode.strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubstring {

    // Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        // Write your code here
        String minString = minWindow(s,t);
        if(minString.equals("")){
            return -1;
        }else{
            return minString.length();
        }
    }

    public String minWindow(String s, String t) {

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











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinimumLengthSubstring().run();
    }
}
