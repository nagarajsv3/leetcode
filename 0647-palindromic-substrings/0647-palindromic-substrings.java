class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int counter=0;
        String longest = ""; 
        //Traverse Diagonally
        for(int gap = 0; gap<s.length(); gap ++){
            //start at row 0 and end at last col
            for(int row=0, col = gap ; col < s.length(); row++, col++){
                if(gap==0){
                    dp[row][col] = true;
                    longest = s.substring(row, col+1);
                    counter++;
                }else if(gap==1){
                    if(s.charAt(row) == s.charAt(col)){
                        dp[row][col] = true;
                        longest = s.substring(row, col+1);
                        counter++;
                    }
                }else{
                    if(s.charAt(row) == s.charAt(col)){
                        if(dp[row+1][col-1] == true){
                            dp[row][col] = true;
                            longest = s.substring(row, col+1);
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }
}