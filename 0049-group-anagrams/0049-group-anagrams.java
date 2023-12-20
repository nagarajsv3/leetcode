class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Create Anagram Map
        Map<Map<Character, Integer> , List<String>> anagramMap = new HashMap<>();

        for(String each : strs){
            //Create and Compute Frequency Map
            Map<Character, Integer> freqMap = new HashMap<>();
            for(int i=0; i<each.length() ; i++){
                freqMap.put(each.charAt(i) , freqMap.getOrDefault(each.charAt(i),0) +1 );
            }

            //Add or Update Freq Map to Anagram Map
            if(anagramMap.containsKey(freqMap)){
                anagramMap.get(freqMap).add(each);
            }else{
                List<String> list = new ArrayList<>();
                list.add(each);
                anagramMap.put(freqMap, list);
            }

        }

        //Use Anagram map to compute final result
        List<List<String>> output = new ArrayList<>();
        for(List<String> valuelist : anagramMap.values()){
            output.add(valuelist);
        }
         return output;   
    }
}