package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.strings;

public class AtoIMain {
    public static void main(String[] args) {

        System.out.println(myAtoi("  42"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-21474836482"));



    }

    public static int myAtoi(String s) {

        if(s.isEmpty()){
            return 0;
        }

        s = s.trim();

        if(s.isEmpty()){
            return 0;
        }

        char[] chars = s.toCharArray();

        int index = 0;
        int result = 0;
        int sign = 1;
        int dig = 0;


        while(index < s.length()){

            char ch = chars[index];
            if(index==0 && ch =='-'){
                sign = -1;
                index++;
            }else if(index==0 && ch =='+'){
                index++;
            }else{
                if(Character.isDigit(ch)){
                    char zero = '0';
                    int digit = ch - zero;

                    if(sign == 1){
                        if(result > (Integer.MAX_VALUE / 10) ||
                                result >= (Integer.MAX_VALUE / 10) && digit > 7){
                            return Integer.MAX_VALUE;
                        }else{
                            result = result * 10 + digit;
                            index++;
                        }
                    }else{
                        if(result > (Integer.MAX_VALUE / 10) ||
                                result >= (Integer.MAX_VALUE / 10) && digit >= 8){
                            return Integer.MIN_VALUE;
                        }else{
                            result = result * 10 + digit;
                            index++;

                            if(index==s.length()){
                                result = result * sign ;
                            }
                        }


                    }


                }else{
                    if(sign ==-1){
                        result = result * sign ;
                    }
                    break;
                }


            }


        }


        return result;

    }


}
