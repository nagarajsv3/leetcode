class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length-1;
        int leastsigidx = len-1;
        
        //1 2 4 9 8 7 6 5 3 -> 4th pos
        while( leastsigidx>=0  && nums[leastsigidx] >= nums[leastsigidx + 1]){
            leastsigidx--;
        }
        
        if(leastsigidx >=0){
            int bestidx = len;
            while(bestidx>=0 && nums[bestidx] <= nums[leastsigidx]){
                bestidx--;
            }
            
            if(leastsigidx >=0 && bestidx >=0){
                swap(nums, leastsigidx, bestidx);
            }
            
        }
        
        reverse(nums, Math.max(0, leastsigidx+1), len);
        
        
        
    }
    
    void reverse(int[] nums, int left, int right){
        while(left<=right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    void swap(int[] nums, int fir, int sec){
        int temp = nums[fir];
        nums[fir] = nums[sec];
        nums[sec] = temp;
    }
}