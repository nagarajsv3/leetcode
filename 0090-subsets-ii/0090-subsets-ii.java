class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsetBacktrack(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }
    
    void subsetBacktrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));
        
        for(int i=index ; i<nums.length; i++){
            if(i!=index && nums[i]== nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            subsetBacktrack(i+1, nums, subset, subsets);    
            subset.remove(subset.size()-1);//Remove during backtracking
        }
    }
}