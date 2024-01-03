class Solution {
    public void nextPermutation(int[] nums) {
        
        int leastsigidx = nums.length-2;
        
        //1 2 4 9 8 7 6 5 3
        while(leastsigidx >=0 && nums[leastsigidx] >= nums[leastsigidx+1]){
            leastsigidx--;
        }
        
        if(leastsigidx >=0 ){
            //then only perform swap with best digit
            int bestdigitidx=nums.length-1;
            while(bestdigitidx>=0 && nums[leastsigidx] >= nums[bestdigitidx]){
                bestdigitidx--;
            }
            
            if(bestdigitidx>=0){
                swap(nums, leastsigidx, bestdigitidx);
            }
        }
        
        //reverse 
        int reversestarting = Math.max(0, leastsigidx+1);
        reverse(nums, reversestarting, nums.length-1);
        
    }
    
    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    void reverse(int[] nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}