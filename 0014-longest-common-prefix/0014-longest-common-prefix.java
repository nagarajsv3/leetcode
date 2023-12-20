class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1){
            return strs[0];
        }else{
            String prefix = null;
            for(int i=0; i<strs.length-1 ; i++){
                if(i==0){
                    prefix = prefixOf2Word(strs[i], strs[i+1]);
                }else{
                    prefix = prefixOf2Word(prefix, strs[i+1]);
                }
            }
            
            return prefix;
            
        }
        
    }
    
    
    
    
    public String prefixOf2Word(String first, String second){
        if(first.equals(second)){
            return first;
        }else if(first.isEmpty() || second.isEmpty()){
            return "";
        }else{
            int counter=0;
            int firstLen = first.length();
            int secondLen = second.length();
            StringBuffer buf = new StringBuffer();
            
            while(counter < firstLen && counter < secondLen){
                if(first.charAt(counter) == second.charAt(counter)){
                    buf.append(first.charAt(counter));
                    counter++;
                }else{
                    break;
                }
            }
            
            return buf.toString();
            
        }
        
    }
}