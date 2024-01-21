class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] output = new int[nums.length-k+1];
        int m=0;
        for(int i=0; i<nums.length; i++){
            //Remove Out of bound
            if(!deq.isEmpty() && deq.peek() == (i-k)){
                deq.poll();
            }
            //Remove ALl smaller
            while(!deq.isEmpty() && nums[i] > nums[deq.peekLast()]){
                deq.pollLast();
            }    
            //Add
            deq.offer(i);    
            //Peek    
            if(i >= (k-1)){
                output[m++] = nums[deq.peek()];
            }
        }
        return output;
    }
}