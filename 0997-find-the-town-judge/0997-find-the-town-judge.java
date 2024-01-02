class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inarr = new int[n+1];
        int[] outarr= new int[n+1];
        
        for(int i=0; i< trust.length ; i++){
            int[] edge = trust[i];
            inarr[edge[1]] = inarr[edge[1]]+ 1;
            outarr[edge[0]] = outarr[edge[0]]+ 1;
        }
        
        for(int i=1;i<=n;i++){
            if(inarr[i] == (n-1) && outarr[i] == 0){
                return i;
            }
        }
                
        return -1;
                
    }
    
}