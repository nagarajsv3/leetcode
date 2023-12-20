class Solution {
    public int firstUniqChar(String s) {
        //Create Frequency Map
        Map<Character, Integer> map = new HashMap();
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        //Iterate through String and Look for First Occurence with Value 1
        for(int i=0;i<s.length() ; i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
        
    }
}