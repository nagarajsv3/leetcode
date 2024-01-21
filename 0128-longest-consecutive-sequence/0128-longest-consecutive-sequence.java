class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();   //5 4 3 2 1
        
        //Add elements to set
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
        int max = 0;
        for(int i=0;i<nums.length; i++){   //5 4 3 2 1
            if(set.contains(nums[i]-1)){   //4 3 2 1 0N
                //Dont do anything
            }else{
                int cnt=0;
                while(set.contains(nums[i])){ //2 3 4 5
                    cnt++;                   //2 3 4 5
                    nums[i]++;
                }
                max = Math.max(max,cnt);
            }
        }
        return max;
        //TC O(N)
        //SC O(1)
    }
}