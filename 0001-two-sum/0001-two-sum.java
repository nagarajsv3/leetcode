class Solution {
    public int[] twoSum(int[] nums, int target) { //2 , 7 , 11 , 15   target = 9 
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length ; i++){   // i=0 , 1; nums[i]=2  , 7 
            if(map.containsKey(target - nums[i])){ //9-2   9-7=2
                output[0] = i;  //1
                output[1] = map.get(target- nums[i]);  //0
                return output;
            }
            map.put(nums[i] , i);   // (2, 0)
        }
        return output;
    }

    //TC - O(N)
    //SC - O(N)
}