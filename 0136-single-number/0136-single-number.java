import java.util.HashMap;
import java.util.Map;
class Solution {
    public int singleNumber(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
                map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}