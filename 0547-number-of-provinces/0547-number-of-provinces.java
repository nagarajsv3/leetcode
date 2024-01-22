class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adjlist.get(i).add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        int cnt=0;
        
        for(int i=0;i<n;i++){
            if(visited[i] ==false){
                bfs(i,visited, adjlist);
                cnt++;
            }
        }
        return cnt;
    }
    
    void bfs(int i, boolean[] visited, List<List<Integer>> adjlist){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = true;
        
        while(!q.isEmpty()){
            int pnode = q.poll();
            
            for(int neigh : adjlist.get(pnode)){
                if(visited[neigh] ==false){
                    q.offer(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }
}