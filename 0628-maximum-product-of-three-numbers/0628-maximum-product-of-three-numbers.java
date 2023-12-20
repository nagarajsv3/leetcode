class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            maxHeap.offer(num);
            minHeap.offer(num);
        }

        int firstMax = maxHeap.poll();
        int secondMax = maxHeap.poll();
        int thirdMax = maxHeap.poll();

        int firstMin = minHeap.poll();
        int secondMin = minHeap.poll();

        return Math.max( firstMin * secondMin * firstMax , firstMax * secondMax * thirdMax);

    }
}