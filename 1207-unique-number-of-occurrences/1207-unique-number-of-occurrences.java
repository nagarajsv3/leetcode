import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int each : arr){
            table.put(each, table.getOrDefault(each,0)+1);
        }

        Set<Integer> uniqueOccSet = new HashSet<>();
        Iterator<Integer> it = table.keySet().iterator();
        while(it.hasNext()){
            Integer occ = it.next();
            if(uniqueOccSet.contains(table.get(occ))){
                return false;
            }else{
                uniqueOccSet.add(table.get(occ));
            }

        }

        return true;
        
    }
}