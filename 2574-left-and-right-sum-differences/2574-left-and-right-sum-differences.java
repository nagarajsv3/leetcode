class Solution {
    public int[] leftRightDifference(int[] nums) {
        //Calculate LeftSum
        int[] leftsum = new int[nums.length]; 
        calculateleftsum(leftsum, nums);

        //Calculate RightSum
        int[] rightsum  = new int[nums.length];
        calculaterightsum(rightsum, nums);

        //Calculate Answer 
        int[] answer  = new int[nums.length];   
        calculateAnswer(leftsum , rightsum, answer);
        return answer;
    }

    void calculateleftsum(int[] leftsum, int[] nums){
        int sum = 0; 
        for(int i=0; i<leftsum.length ; i++){
            if(i==0){
                leftsum[i] = 0;
            }else{
                sum = sum + nums[i-1];
                leftsum[i] = sum;
            }
        }
    }

    void calculaterightsum(int[] rightsum, int[] nums){
        int sum = 0; 
        for(int i=rightsum.length-1; i>=0 ; i--){
            if(i==rightsum.length-1){
                rightsum[i] = 0;
            }else{
                sum = sum + nums[i+1];
                rightsum[i] = sum;
            }
        }
    }

    void calculateAnswer(int[] leftsum, int[] rightsum, int[] ans){
        for(int i=0; i<ans.length; i++){
            ans[i] = Math.abs(leftsum[i] - rightsum[i]);
        }
    }
}