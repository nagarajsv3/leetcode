class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == haystack.length()){
            return needle.equals(haystack) ? 0 : -1;
        }        
        if(needle.length() > haystack.length()){
            return -1;
        }
            
        int needleLength = needle.length();            
        for(int hayPo=0 ;  ((hayPo + needleLength) <= haystack.length()) ; hayPo++){            
            String tempStr = haystack.substring(hayPo, hayPo+needleLength);            
            if(needle.equals(tempStr)){
                return hayPo;
            }                            
        }        
        return -1;                
    }
}