class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int end=nums.length-2;
        int idx =  singleelemrec(low, end, nums);
        return nums[idx];
    }
    
    int singleelemrec(int low, int end, int[] nums){
        if(low>end){
            return low;
        }
        
        int mid = (low + end)/2;
        
        if(mid %2 ==0){
            if(nums[mid] == nums[mid+1]){
                return singleelemrec(mid+1, end, nums);
            }else{
                return singleelemrec(low, mid-1, nums);
            }
        }else if(mid %2 ==1){
            if(nums[mid] == nums[mid-1]){
                return singleelemrec(mid+1, end, nums);
            }else{
                return singleelemrec(low, mid-1, nums);
            }
        }
        return -1;
    }
}