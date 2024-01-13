class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetsBacktrack(0, nums, subset, subsets);
        return subsets;
    }
    
    void subsetsBacktrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));
        
        for(int i=index; i<nums.length; i++){
            subset.add(nums[i]);
            subsetsBacktrack(i+1, nums, subset, subsets);
            subset.remove(subset.size()-1);
        }
    }
}