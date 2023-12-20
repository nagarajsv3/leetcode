import java.lang.Math;
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        if(digits[len-1] != 9){
            digits[len-1] = digits[len-1] + 1;
            return digits;
        }else{
            
            for(int i = len-1 ; i>=0 ; i--){
                if(digits[i] == 9){
                    digits[i] = 0;                
                }else{
                    digits[i] = digits[i] + 1;
                    return digits;
                }    
            }
            
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
            
        }
        
        
    }
    
}