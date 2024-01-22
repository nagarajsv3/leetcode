class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int each : nums){
            pq.offer(each);
        }
        
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();

    }

    //Time Complexity - O(log n) + O(k * log n) = O(K * log n)
    //Space Complexity - O(n)
}