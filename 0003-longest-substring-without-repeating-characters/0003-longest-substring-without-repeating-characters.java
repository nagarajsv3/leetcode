class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0; 
        int lensub = 0;  //1  2  3
        Map<Character, Integer> indexmap = new HashMap<>(); //{(a,3), (b,1), (c,2) }
        
        int left = 0; //0       1
        int right= 0; //1  2  3
        
        while(left < s.length() && right < s.length()){      //tmmzuxt
            Character ch = s.charAt(right);
        
            if(indexmap.containsKey(ch)){ //(m,1)
                //is it in the range
                int val = indexmap.get(ch); //
                if(val < left){
                    //Out of bound
                    indexmap.put(ch, right);
                    lensub = lensub+1;
                    right++;
            

                }else{
                    //Jump to next char
                    left = val+1;      //2
                    indexmap.put(ch, right);
                    lensub = right-left+1;
                    right++;
                }
                
            }else{
                indexmap.put(ch, right);//(t,0)(m,1)
                lensub = lensub+1;      //1  -> 2
                right++;                //0->1->2
            }   
            maxlen = Math.max(lensub, maxlen); //1->2
        }
        
        return maxlen;
        
    }
}