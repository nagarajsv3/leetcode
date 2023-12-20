class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        boolean duplicatePresent = false;
        
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for(int num : nums){
            if(numMap.get(num) != null){
                duplicatePresent = true;
                break;
            }else{
                numMap.put(num,num);
            }
        }
        
        return duplicatePresent;
        
    }
}