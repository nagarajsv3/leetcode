class Solution {
    public int minStartValue(int[] nums) {
        int minvalue = 0;
        int stepsum = 0;
        for(int i=0; i<nums.length; i++){
            stepsum = stepsum + nums[i];
            minvalue = Math.min(minvalue, stepsum);
                        
        }

        if(minvalue < 0){
            return 1 + Math.abs(minvalue);
        }else{
            return 1;
        }
    }

    //TC O(N)
    //SC O(1)
}