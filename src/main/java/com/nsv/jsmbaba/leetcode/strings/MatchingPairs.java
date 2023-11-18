package com.nsv.jsmbaba.leetcode.strings;

public class MatchingPairs {


    // Add any helper functions you may need here

    int matchingPairs(String s, String t) {
        // Write your code here

        if(s.equals(t)){
            return s.length()-2;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int firstIdx=0;
        int secondIdx=0;
        int count=0;
        int mismatch=0;

        for(int i=0; i<schars.length ; i++){
            if(schars[i] == tchars[i]){
                System.out.print("Match:"+schars[i]+"=="+tchars[i]);
                System.out.println();

                count++;
            }else{
                System.out.print("MisMatch:"+schars[i]+"=="+tchars[i]);
                System.out.println();
                mismatch++;
                if (mismatch==1){
                    firstIdx = i;
                }else{
                    secondIdx = i;
                }
            }
        }

        swap(schars,firstIdx, secondIdx);

        if(schars[firstIdx] == tchars[firstIdx]){
            System.out.print(schars[firstIdx]+"=="+tchars[firstIdx]);
            System.out.println();
            count++;
        }
        if(schars[secondIdx] == tchars[secondIdx]){
            System.out.print(schars[secondIdx]+"=="+tchars[secondIdx]);
            System.out.println();
            count++;
        }

        return count;
    }



    void swap(char[] s, int fidx, int sidx ){
        char temp = s[fidx];
        s[fidx] = s[sidx];
        s[sidx] = temp;
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
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
