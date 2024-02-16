class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int end = nums.length-2;
        int idx = singleelementindex(low, end, nums);
        return nums[idx];
    }
    
    int singleelementindex(int low, int end, int[] nums){
        if(low > end){
            return low;
        }
        
        int mid = (low+end)/2;
        
        if(mid%2==0){
            if(nums[mid] == nums[mid+1]){
                return singleelementindex(mid+1, end, nums);
            }else{
                return singleelementindex(low, mid-1, nums);
            }
        }else{
            if(nums[mid] == nums[mid-1]){
                return singleelementindex(mid+1, end, nums);
            }else{
                return singleelementindex(low, mid-1, nums);
            }   
        }
    }
}