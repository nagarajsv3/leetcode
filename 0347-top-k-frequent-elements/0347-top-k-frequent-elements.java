class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int each : nums){
            map.put(each, map.getOrDefault(each, 0)+1);
        }
        
        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                int o1v = o1.getValue();
                int o2v = o2.getValue();
                return Integer.compare(o2v, o1v);
            }
        };
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        
        int[] output = new int[k];
        int m=0;
        for(int i=0;i<k;i++){
            output[m++] = pq.poll().getKey();
        }
        return output;
    }
}