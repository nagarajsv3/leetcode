class Solution {
    public int removeElement(int[] nums, int val) {
      int counter=0;
      //   3  2  2  3
      for(int i=0, j=0; j <nums.length ; i++, j++){
        while( j < nums.length && nums[j] == val ){
          j++;
        }
        if(j < nums.length){
          nums[i] = nums[j];
          counter++;

        }
      }

      return counter;
    }
}