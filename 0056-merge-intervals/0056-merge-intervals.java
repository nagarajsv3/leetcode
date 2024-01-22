class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x,y)-> x[0] - y[0]);
        
        int[][] output = new int[intervals.length][2];
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        int k=0;
        for(int[] each : intervals){
            if(each[0] <= end){
                end = Math.max(each[1], end);
            }else{
                //Copy all range except last one
                int[] mint = new int[2];
                mint[0] = start;
                mint[1] = end;
                output[k++] = mint;
                
                //pre condition for next iteration
                start = each[0];
                end = each[1];
            }
        }

        //Copy last range
        int[] mint2 = new int[2];
        mint2[0] = start;
        mint2[1] = end;
        output[k++] = mint2;
        
        return Arrays.copyOfRange(output, 0,k);
    }
}