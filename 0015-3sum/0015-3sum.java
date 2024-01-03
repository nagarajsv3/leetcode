class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finallist = new ArrayList<>();
        
        //Sort Array - O(n logn)
        Arrays.sort(nums);
        
        int i=0;
        while(i<nums.length-2){
            
            
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[k]+nums[j] == 0){
                    captureTriplet(nums[i], nums[j], nums[k], finallist);
                    do{
                        j++;
                    }while(j<k && nums[j]==nums[j-1]);
                    do{
                        k--;
                    }while(j<k && nums[k]==nums[k+1]);
                    
                }else if(nums[i]+nums[k]+nums[j] > 0){
                    do{
                        k--;
                    }while(j<k && nums[k]==nums[k+1]);
                }else if(nums[i]+nums[k]+nums[j] < 0){
                    do{
                        j++;
                    }while(j<k && nums[j]==nums[j-1]);
                }

            }
            
            do{
                i++;    
            }while(i<nums.length-2 && nums[i] == nums[i-1]);
            
        }
        
        return finallist;
    }
    
    void captureTriplet(int fnum, int snum, int tnum, List<List<Integer>> finallist){
        List<Integer> list = new ArrayList<>();
        list.add(fnum);
        list.add(snum);
        list.add(tnum);
        finallist.add(list);
    }
}