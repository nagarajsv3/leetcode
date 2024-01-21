class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        String output="";
        int cnt=0;
        while(i< word1.length() && j<word2.length()){
            if(cnt%2 == 0){
                output += word1.charAt(i++);     
            }else{
                output += word2.charAt(j++);
            }
            cnt++;
        }
        
        while(i<word1.length() && j==word2.length()){
            output += word1.charAt(i++); 
        }
        
        while(i==word1.length() && j<word2.length()){
            output += word2.charAt(j++); 
        }

        return output;
        
    }
}