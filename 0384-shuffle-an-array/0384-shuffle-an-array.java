class Solution {

    private int[] original;
    private int[] array;
    
    //Explanation
    //https://www.youtube.com/watch?v=i8kD33wx9Mo
    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        
      
        Random random = new Random();
        
        for(int index = this.array.length-1 ; index>0; index--){
            int randIndex = random.nextInt(index+1);
            swap(array, index, randIndex);        
        }
        return array;
    }
    
    void swap(int[] array, int index, int randIndex){
        int temp = array[index];
        array[index] = array[randIndex];
        array[randIndex] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */