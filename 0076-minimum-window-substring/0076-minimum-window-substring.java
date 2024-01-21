class Solution {
    public String minWindow(String s, String t) {
        //"ADOBECODEBANC" "ABC"
        if(t ==null || s==null){
            return "";
        }
        if(s.length() == t.length() && s.equals(t)){
            return t;
        }
        
        if(t.length()> s.length()){
            return "";
        }
        
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);        
        }
        count = freqMap.size();
        
        int acp = 0;
        int rep = 0;
        int startPos = Integer.MAX_VALUE;
        int endPos = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        String substr="";
        boolean found =false;
        while(acp< s.length() && rep<s.length()){
            
            while(acp< s.length() && count > 0){
                
                //Keep acquiring
                char sch = s.charAt(acp);
                if(freqMap.containsKey(sch)){
                    freqMap.put(sch, freqMap.get(sch)-1);
                    if(freqMap.get(sch) ==0 ){
                        count--;
                    }
                }
                acp++;
            }
            
            while(rep<s.length() && count == 0){
                //Keep Releasing
                found=true;
                char sch = s.charAt(rep);
                if(freqMap.containsKey(sch)){
                    freqMap.put(sch, freqMap.get(sch)+1);
                    if(freqMap.get(sch)>0){
                        count++;
                    }
                }
                rep++;
            }
            
            if(found && (acp-rep+1) < minLen ){
                    minLen = acp-rep+1;
                    startPos = rep - 1;
                    endPos = acp -1;
                    substr = s.substring(startPos, endPos+1);
                System.out.println("startpos="+startPos+" ;endPos="+endPos+" ;substr="+substr+";minLen="+minLen);
                    
                found=false;
            }
        }
        return substr;
}
}