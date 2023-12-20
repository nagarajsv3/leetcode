class Solution {
    public int[][] merge(int[][] intervals) {
        Integer[][] intgInts = sortIntervals(intervals);
        int[][] output = new int[intervals.length][intervals[0].length];
        int[][] output2 = mergeIntervals(intgInts, output);
        return output2;
    }
    
    
    int[][] mergeIntervals(Integer[][] intervals, int[][] output ){
        Integer[] bestmergedint = intervals[0];
        int k=0;
        for(int i=1; i<intervals.length; i++){            
            if(intervals[i][0] <= bestmergedint[1] ){ //  (1,4) (2,2) (2,6)
                if(intervals[i][1] < bestmergedint[1]){
                    //no need to do
                }else{
                    bestmergedint[1] = intervals[i][1];
                }
            }else{
                output[k] = new int[2]; 
                output[k][0] = bestmergedint[0];
                output[k][1] = bestmergedint[1];
                
                bestmergedint[0] = intervals[i][0];
                bestmergedint[1] = intervals[i][1];
                k=k+1;
            }
        }
        
        
        output[k] = new int[2]; 
        output[k][0] = bestmergedint[0];
        output[k][1] = bestmergedint[1];
        
        int[][] output2 = new int[k+1][2];
        output2 = Arrays.copyOfRange(output, 0, k+1);
        return output2;        
    }
    
    Integer[][] sortIntervals(int[][] intervals){
        Integer[][] intgInt = new Integer[intervals.length][intervals[0].length]; 
        for(int i=0; i<intervals.length; i++){
            intgInt[i] = new Integer[2];
            intgInt[i][0] = intervals[i][0];
            intgInt[i][1] = intervals[i][1];
        }   
        
        Comparator<Integer[]> comp = new Comparator<>(){
            @Override
            public int compare(Integer[] i1, Integer[] i2){
                return i1[0]-i2[0];
            }    
        };
        Arrays.sort(intgInt, comp);
        

        return intgInt;
    }
}