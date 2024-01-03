class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> finallist = new ArrayList<>();
        
        
        for(int i=0; i<nums.length-2 ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
                //To avoid duplicate triplet
            }
        
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    finallist.add(list);
                    
                    //0 2 -1 -1 -2 -2
                    do{
                        k--;    
                    }while(k>j && nums[k]==nums[k+1]);
                    
                    do{
                        j++;
                    }while(k>j && nums[j] == nums[j-1] );
                }else if(nums[i]+ nums[j]+nums[k] >0){
                        k--;
                    
                }else if(nums[i]+ nums[j]+nums[k] <0){
                        j++;    

                }   
            }
            
        }
        return finallist;
    }
}