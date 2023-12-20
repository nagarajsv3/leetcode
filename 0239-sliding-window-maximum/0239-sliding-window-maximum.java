class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //deque to maintain index of values in the decreasing order
        Deque<Integer> deque = new ArrayDeque<>();
        int outputLn = 0;

        if(k==1){
            outputLn = nums.length;
        }else{
            outputLn = nums.length-k+1;
        }

        int[] output = new int[outputLn];

        for(int i=0; i<nums.length; i++){
            //Removing Out Of Bound Indexes from Front
            if(! deque.isEmpty() && deque.peek() == (i-k)){
                deque.poll();
            }
            //Removing Smaller Element Indexes from Back //We are looking for max. so no point of mainting index of small values
            while(! deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            //Add index to Deque 
            deque.offer(i);
            //Writing to output
            if(i >= k-1){
                output[i-(k-1)] = nums[deque.peek()];
            }
        }

            return output;

    }
}