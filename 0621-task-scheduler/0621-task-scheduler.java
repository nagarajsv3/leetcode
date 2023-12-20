class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Task Frequency Map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char task : tasks){
            frequencyMap.put(task , frequencyMap.getOrDefault(task,0)+1);
        }

        //Adding Priority task freq to MaxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            maxHeap.offer(entry.getValue());
        }

        Queue<Integer[]> queue = new ArrayDeque<>();

        int timer = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            timer++;
            if(!maxHeap.isEmpty()){
                int taskfreq = maxHeap.poll();
                taskfreq--;

                if(taskfreq!=0){
                    queue.offer(new Integer[]{taskfreq, timer+n});
                }

            }

            //At time , peek from queue 
            if(!queue.isEmpty()){
                Integer[] toptaskQ = queue.peek();
                if(toptaskQ[1] == timer){
                    maxHeap.offer(queue.poll()[0]);
                }
            }
        }
        return timer;

        //TC O(nlogn) Heapify 
        //SC O(n)
    }
}