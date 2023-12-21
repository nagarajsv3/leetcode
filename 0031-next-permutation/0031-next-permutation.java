class Solution {
    public void nextPermutation(int[] nums) {
        
        //FInd the least significant index // 1 2 4 9 8 7 6 5 3 -> 4
        int len = nums.length-1;
        int pivotidx = nums.length-2;
        while(pivotidx >=0 && nums[pivotidx] >= nums[pivotidx+1]){
            pivotidx--;
        }
        
        //Find the best digit to replace
        if(pivotidx>=0){
            int bigidx = nums.length-1;
            while(bigidx >=0 && nums[bigidx] <= nums[pivotidx]){
                bigidx--;
            }
            //Swap            
            swap(nums, pivotidx, bigidx);
        }
        
        //Reverse
        reverse(nums, Math.max(pivotidx+1, 0), len);
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