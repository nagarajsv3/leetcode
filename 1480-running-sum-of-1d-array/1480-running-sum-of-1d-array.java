class Solution {
    public int[] runningSum(int[] nums) {
        //Prefix sum
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }    
        return nums;
    }

    //TC O(N)
    //SC O(1)
}