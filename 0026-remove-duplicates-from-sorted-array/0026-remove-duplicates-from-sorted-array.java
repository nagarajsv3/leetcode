class Solution {
    public int removeDuplicates(int[] nums) {
        
        int counter = 1;
        //1 1 2
        for(int i=1, j=1; j<nums.length; i++, j++){
            while( j<nums.length && nums[i-1] == nums[j]){
                j++;
            }
            if(j<nums.length){
                nums[i] = nums[j];
                counter++;
            }
        }

        return counter;

    }
}