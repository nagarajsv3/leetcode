class Solution {
    public boolean isPalindrome(String s) {
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