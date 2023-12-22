class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Sort Array nums
        //Fix i ; move j from i+1 till < k ; Move k from len-1 till >j
        
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2 ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
                //To avoid duplicate triplet
            }
            int j=i+1; 
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplets.add(triplet);
                    
                    do{
                        j++;
                    }while(j<k && nums[j]==nums[j-1]);
                    
                    do{
                        k--;
                    }while(k>j && nums[k] == nums[k+1]);
                    
                }else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }else if(nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }
                
            }
        }
        
        return triplets;
    }
}