class Solution {
    public void moveZeroes(int[] nums) {
        
        int counter = 0;
        for(int i=0, j=0 ; j<nums.length ; i++, j++){
            while(j< nums.length && nums[j] ==0){
                counter++;
                j++;
            }

            if(j<nums.length){
                nums[i] = nums[j];                
            }

        }

        for(int k=0, m = nums.length-1 ; k<counter; m--, k++){
            nums[m] = 0;
        }
    }
}