class Solution {
    //[0,1,0,2,1,0,1,3,2,1,2,1]
    public int trap(int[] height) {
        int len = height.length - 1;
        int left = 0;
        int right = len;

        int leftmax = 0;
        int rightmax = 0;
        int result = 0;
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        while(left < right ){
            if(height[left] < height[right]){
                if(height[left] < leftmax){
                    result = result + leftmax - height[left];
                }else{
                    leftmax = height[left];
                }
                left++;
        
            }else{
                if(height[right] > rightmax){
                    rightmax = height[right];
                }else{
                    result = result + rightmax - height[right];
                }
                right--;
            }
        }
        
        return result;
//TC - O(N)
//SC - O(1)
    }
}