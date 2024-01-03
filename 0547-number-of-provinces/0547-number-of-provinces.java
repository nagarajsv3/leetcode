class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] isvisited = new boolean[n];
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j] == 1){
                    adjlist.get(i).add(j);
                }
            }
        }
        
        int counter=0;
        for(int i=0;i<n;i++){
            if(isvisited[i] ==false){
                bfs(i, isvisited, adjlist );
                counter++;
            }
        }
        
        return counter;
    }
    
    void bfs(int node, boolean[] visited, List<List<Integer>> adjlist ){
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        
        while(! queue.isEmpty()){
            int pnode = queue.poll();
            
            for(int neigh : adjlist.get(pnode)){
                if(visited[neigh] == false){
                    queue.offer(neigh);
                    visited[neigh] = true;
                }
            }
        }
        
    }
    
    
}