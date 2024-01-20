class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> permuts = new ArrayList<>();
        List<Integer> permut = new ArrayList<>();
        permutations(nums, visited, permut, permuts);
        return permuts;

    }

    void permutations(int[] nums, boolean[] visited, List<Integer> permut, List<List<Integer>> permuts){

        if(permut.size()==nums.length){
            permuts.add(new ArrayList<>(permut));
        }

        for(int i=0; i<nums.length;i++){
            if(visited[i] == true){
                continue;
            }

            permut.add(nums[i]);
            visited[i]=true;
            permutations(nums, visited, permut, permuts);
            permut.remove(permut.size()-1);
            visited[i]=false;
        }
    }


        
}