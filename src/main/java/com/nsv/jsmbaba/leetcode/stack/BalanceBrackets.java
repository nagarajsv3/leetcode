package com.nsv.jsmbaba.leetcode.stack;

import java.util.Stack;

public class BalanceBrackets {

    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();


        //"{{[[(())]]}}";
        for(int i=0; i< s.length(); i++){

            char c = s.charAt(i);

            if(c == '{' || c == '[' || c == '(' ){
                stack.push(c);
            }

            if(c == '}' || c== ']' || c==')'){

                if(stack.isEmpty()){
                    return false;
                }else{
                    Character poppedCh = stack.pop();
                    if(!match(c, poppedCh)){
                        return false;
                    }
                }
            }

        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    boolean match(char closingbracket, char openingbracket){
        if (openingbracket == '[' && closingbracket==']'){
            return true;
        }else if(openingbracket == '{' && closingbracket=='}'){
            return true;
        }else if(openingbracket == '(' && closingbracket==')'){
            return true;
        }
        return false;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        check(expected_1, output_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        boolean output_2 = isBalanced(s_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}