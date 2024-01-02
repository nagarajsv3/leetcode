class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length-1;
        int leastsigidx = len-1;
        
        //1 2 4 9 8 7 6 5 3 -> value 4; pos= 2 -leastsigidx = 2 
        while( leastsigidx>=0  && nums[leastsigidx] >= nums[leastsigidx + 1]){
            leastsigidx--;
        }
        
        if(leastsigidx >=0){
            int bestidx = len;
            while(bestidx>=0 && nums[bestidx] <= nums[leastsigidx]){
                bestidx--;
            }
            //best digit idx value 5; pos= 7 -bestidx = 7 
            
            if(leastsigidx >=0 && bestidx >=0){
                swap(nums, leastsigidx, bestidx);//swap 2th pos & 7th pos
            }
            
        }
        
        reverse(nums, Math.max(0, leastsigidx+1), len); //swap 3rd pos to last pos to get best next permutation value
        
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