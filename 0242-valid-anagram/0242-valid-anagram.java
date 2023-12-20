class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1 );
        }

        

        for(int j=0; j< t.length(); j++){
            char tchar = t.charAt(j);
            map.put(tchar, map.getOrDefault(tchar, 0) -1 );
            if( map.get(tchar) == 0){
                map.remove(tchar);
            }else if(map.get(tchar) < 0){
                return false;
            }
        }

        return map.isEmpty();

    }

    //O(n) + O(n)  = O(n)
    //O(n)
}