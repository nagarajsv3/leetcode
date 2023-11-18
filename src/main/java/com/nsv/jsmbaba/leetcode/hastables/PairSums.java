package com.nsv.jsmbaba.leetcode.hastables;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class PairSums {

    // Add any helper functions you may need here


    int numberOfWays(int[] arr, int k) {
        int count = 0;
        // Write your code here
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for(int each : arr){
            ht.put(each , ht.getOrDefault(each, 0) + 1);
        }

        for(int each : arr){
            Set<Integer> keyset = ht.keySet();
            Iterator<Integer> it = keyset.iterator();
            while(it.hasNext()){
                Integer key = it.next();

                if(each + key.intValue() == k){
                    if(each == key.intValue() && ht.get(key) == 1){
                        System.out.println("Only One Occurence of int"+each);
                    }else if(each == key.intValue() && ht.get(key) > 1){
                        System.out.println("Found.Only One Occurence of int"+each);
                        count = count + ht.get(key) -1 ;
                    }else{
                        count = count + ht.get(key);
                    }
                }

            }

        }

        return count/2;
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

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSums().run();
    }
}