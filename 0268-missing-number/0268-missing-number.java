class Solution {
    public int missingNumber(int[] nums) {
        int[] occ = new int[nums.length+1];
        
        for(int i=0; i<nums.length;i++){
            occ[nums[i]] = occ[nums[i]]+ 1;
        }
        
        for(int i=0; i< occ.length ; i++){
            if(occ[i] == 0){
                return i;
            }
        }
        return -1;
    }
}