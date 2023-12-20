class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : nums){
            maxHeap.offer(num);
        }

        while(k>1){
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();

    }

    //Time Complexity - O(log n) + O(k * log n) = O(K * log n)
    //Space Complexity - O(n)
}