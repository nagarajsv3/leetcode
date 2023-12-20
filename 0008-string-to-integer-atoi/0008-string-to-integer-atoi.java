class Solution {
    public int myAtoi(String s) {
        
        //Trim spaces
        s= s.trim();

        if(s.length()==0){
            return 0;
        }

        //Identify + or -
        char firstchar = s.charAt(0);
        boolean negative = false;
        if(firstchar == '-'){
            negative = true; 
        }


        int result = 0;
        for(int i=0 ; i< s.length(); i++){

            if(i==0 &&  (s.charAt(i)=='+' || s.charAt(i)=='-') ){
                continue;
            }

            //Get Digit
            int digit = s.charAt(i) - '0';        
            if(digit >=0 && digit<=9){
                if(negative == false){                    
                    //Check to see if the result * 10 + digit leads to overflow
                    if(result > Integer.MAX_VALUE / 10 ||
                        (result >= Integer.MAX_VALUE/10 && digit >=8)){
                            System.out.println("Result1="+result);
                            return Integer.MAX_VALUE;
                    }else{
                            result = result * 10 + digit;                            
                    }
                }else{                    
                    //Check to see if the result * 10 + digit leads to overflow
                    if(result > Integer.MAX_VALUE / 10 ||
                        (result >= Integer.MAX_VALUE/10 && digit >=8)){
                            System.out.println("Result2="+result);
                            return Integer.MIN_VALUE;
                    }else{
                        result = result * 10 + digit;
                }
            }
            }else{
                break;
            }            
        }
        System.out.println("Result3="+result);
        return negative ? -1 * result : result;
    }

    //TC - O(N)
    //SC - O(1)
}