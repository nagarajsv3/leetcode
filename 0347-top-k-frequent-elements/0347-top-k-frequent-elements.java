class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int each : nums){
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                return Integer.compare(((Map.Entry<Integer, Integer>)o2).getValue(), ((Map.Entry<Integer, Integer>)o1).getValue());
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(comparator);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxHeap.offer(entry);
        } 

        int[] output = new int[k];
        for(int i=0; i<k ; i++){
            output[i] = maxHeap.poll().getKey();
        }

        return output;
    }
}