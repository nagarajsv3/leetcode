class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> quads = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=(i+1) && nums[j] == nums[j-1]){
                    continue;
                }
                
                int left = j+1;
                int right = nums.length-1;
                
                while(left < right){
                    if((long)nums[i] + (long)nums[j] + (long)nums[left]+ (long)nums[right] ==(long)target){
                        //Found Quad
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        quads.add(quad);
                        
                        do{
                            left++;
                        }while(left<right && nums[left]==nums[left-1]);
                        
                        do{
                            right--;
                        }while(left<right && nums[right] == nums[right+1]);
                        
                    }else if((long)nums[i] + (long)nums[j] + (long)nums[left]+ (long)nums[right] > (long)target){
                        right--;
                    }else if((long)nums[i] + (long)nums[j] + (long)nums[left]+ (long)nums[right] < (long)target){
                        left++;
                    }
                    
                }
                
            }
            
            
        }
        return quads;
    }
}