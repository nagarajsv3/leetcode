class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //TC - O(y+x) where y is nlogn  ; x is 2^n
        //SC - O(x) where x is 2^n
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsetBacktrack(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }
    
    void subsetBacktrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));
        
        for(int i=index ; i<nums.length; i++){
            //Condition tp remove duplicates
            if(i!=index && nums[i]== nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            subsetBacktrack(i+1, nums, subset, subsets);    
            subset.remove(subset.size()-1);//Remove during backtracking
        }
    }
}