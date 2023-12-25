class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adjlist = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }
        
        int[] inarr = new int[n+1];
        int[] outarr= new int[n+1];

        
        for(int i=0; i< trust.length ; i++){
            int[] edge = trust[i];
            adjlist.get(edge[0]).add(edge[1]);
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