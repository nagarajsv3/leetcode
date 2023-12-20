class Solution {
  //Number of Unique Elements in the array. We can iterate through array and add it to Set  
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int each : nums){
          if(each > 0){
            set.add(each);
          }

        }

        return set.size();

        //TC O(N)
        //SC O(N)
    }
}