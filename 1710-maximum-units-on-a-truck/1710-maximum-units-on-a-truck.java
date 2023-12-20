class Solution {
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {        
        Comparator<Pair> comp = new Comparator<>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p2.secondval - p1.secondval;
            }
        };

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(comp);
        
        int totalboxes = 0;
        for(int i=0; i<boxTypes.length; i++){
            maxHeap.offer(new Pair(boxTypes[i][0], boxTypes[i][1]));
        }

        int count =0;
        while(count < truckSize && ! maxHeap.isEmpty()){
            Pair pair = maxHeap.poll();
            while(pair.firstval > 0 && count < truckSize){
                totalboxes = totalboxes + 1 * pair.secondval;
                pair.firstval--;
                count++;
            }
        }
        
        return totalboxes;
    }

    //TC O(N)
    //SC O(N)

    public class Pair{
        int firstval;
        int secondval;
        Pair(int _fv, int _sv){
            this.firstval = _fv;
            this.secondval = _sv;
        }
    }
    
}