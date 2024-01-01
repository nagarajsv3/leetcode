class Solution {
    public String minWindow(String s, String t) {
        //"ADOBECODEBANC" "ABC"
        if(t ==null || s==null){
            return "";
        }
        if(s.length() == t.length() && s.equals(t)){
            return t;
        }
        
        //Calculate Freq Map of t
        Map<Character , Integer> map = getFrequencyMap(t);
        int count = map.size();
        
        int min = Integer.MAX_VALUE;
        int substracquirer = 0;
        int bestsubfinder = 0;
        int len = s.length();
        String substr = "";
        boolean found = false;
        
        while(substracquirer < len){
            char ch = s.charAt(substracquirer);
            
            substracquirer++;
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) -1);
                if(map.get(ch) == 0){
                    count = count -1;
                    if(count != 0){
                        continue;
                    }else{
                        while(count==0 && bestsubfinder < len){
                            
                            found = true;
                            char rch = s.charAt(bestsubfinder);
                                       
                            bestsubfinder++;
                            if(map.containsKey(rch)){
                                map.put(rch, map.get(rch) + 1);
                                if(map.get(rch) > 0){
                                    count = count + 1;
                                }
                            }
                        }
                        
                        if(found && min > (substracquirer - bestsubfinder + 1)){
                            
                            min = substracquirer - bestsubfinder + 1;
                            substr = s.substring(bestsubfinder-1, substracquirer);
                        }                                                                     
                    }
                }
            }
        }
        return substr;
        
    }
    
    Map<Character , Integer> getFrequencyMap(String t){
        Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        return map;
    }
}