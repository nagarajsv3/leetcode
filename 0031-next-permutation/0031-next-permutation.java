class Solution {
    public void nextPermutation(int[] nums) {
        //FInd the least significant index // 1 2 4 9 8 7 6 5 3 -> 4
        int pivotidx = nums.length-2;
        while(pivotidx >= 0 && nums[pivotidx] >= nums[pivotidx+1]){
            pivotidx--;
        }
        
        //Find Best TO replace  // 5
        if(pivotidx >= 0){
            int bigidx = nums.length-1;
            while(nums[bigidx] <= nums[pivotidx]){
                bigidx--;
            }

            //Swap //1 2 5 9 8 7 6 4 3
            swap(nums, bigidx, pivotidx);
        }

        //Reverse right // 1 2 5 3 4 6 7 8 9 
        if(pivotidx >= 0){
            reverse(nums, pivotidx+1, nums.length-1);
        }else{
            reverse(nums, 0, nums.length-1);
        }
        
        
    }
    
    void reverse(int[] nums, int left, int right){
        while(left <= right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left ] = nums[right];
        nums[right] = temp;
    }
}