class Solution {
    public int[][] merge(int[][] intervals) {
        sortintervals(intervals);
        return mergeintervals(intervals);
    }
    
    int[][] mergeintervals(int[][] intvs){
        int[] intv = intvs[0];
        int start = intv[0];
        int end = intv[1];
        List<int[]> list = new ArrayList<>();
        
        for(int[] each : intvs){
            if(each[0] <= end){
                end = Math.max(end, each[1]);
            }else{
                list.add(new int[]{start, end});
                start = each[0];
                end = each[1];
            }
        }
        
        list.add(new int[]{start, end});
        
        //Form output
        int[][] out = new int[list.size()][2];
        for(int i=0;i<out.length;i++){
            out[i] = list.get(i);
        }
        return out;
    }
    
    void sortintervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    }
}