class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's algo

        int sum = 0;
        int maxSubArrSum = nums[0];

        for(int i=0; i<nums.length; i++){
          sum = sum + nums[i];
          maxSubArrSum = Math.max(sum, maxSubArrSum);

          //If sum is negative then make it zero
          sum = sum < 0 ? 0 : sum ; 
        }
        return   maxSubArrSum;      
    }
}