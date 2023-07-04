package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.strings;

public class PalindromeMain {

    public static void main(String[] args) {
        String input1 = "A man, a plan, a canal: Panama";
        System.out.println(input1+":"+isValidPalindrome(input1));


        String input2 = "race a car";
        System.out.println(input2+":"+isValidPalindrome(input2));

        String input3 = " ";
        System.out.println(input3+":"+isValidPalindrome(input3));



    }





    public static boolean isValidPalindrome(String s){
        if(s.isEmpty()){
            return true;
        }

        int headPos =0;
        int tailPos =s.length()-1;
        char headChar;
        char tailChar;

        while(headPos<=tailPos){
            headChar = Character.toLowerCase(s.charAt(headPos));
            tailChar = Character.toLowerCase(s.charAt(tailPos));

            if(! Character.isLetterOrDigit(headChar)){
                headPos++;
            }else if(! Character.isLetterOrDigit(tailChar)){
                tailPos--;
            }else{
                if(headChar!=tailChar){
                    return false;
                }

                headPos++;
                tailPos--;

            }

        }

        return true;
    }


}
