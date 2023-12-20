import java.util.*;
class Solution {
    public int romanToInt(String s) {
        int value = 0;
        Hashtable<Character, Integer> ht = new Hashtable<>();
        populateHashtable(ht);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(i+1 < s.length() && ht.get(c) < ht.get(s.charAt(i+1))){
                value = value - ht.get(c);
            }else if(i+1 < s.length() && ht.get(c) >= ht.get(s.charAt(i+1))){
                value = value + ht.get(c);
            }else {
                value = value + ht.get(c);
            }
        }
        return value;

    }

    private void populateHashtable(Hashtable<Character, Integer> ht){
        ht.put('I',1);        
        ht.put('V',5);
        ht.put('X',10);        
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D',500);
        ht.put('M',1000);
    }
}