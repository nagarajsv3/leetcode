class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);             // O(N log N )
        for(int i=0; i< nums.length ; i++){     // O(N log N  + N)
            if(i==0 || i>0 && nums[i] !=nums[i-1]){
                int j=i+1 ;
                int k=nums.length-1;
                while(j<nums.length && k<nums.length && j < k){ // O(N log N + N^2)
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[j]); temp.add(nums[k]);
                        list.add(temp);
                        do{
                            j++;
                        }while(j<nums.length && nums[j] == nums[j-1]);
                        do{
                            k--;
                        }while(k>0 && nums[k] == nums[k+1]);
                    }else if(nums[i] + nums[j] + nums[k] > 0){
                        k--;
                    }else if(nums[i] + nums[j] + nums[k] < 0){
                        j++;
                    }
                }
            }
        }
        return list;
    }

    //TC O(N^2)
    //SC O(U) Unique triplets
}