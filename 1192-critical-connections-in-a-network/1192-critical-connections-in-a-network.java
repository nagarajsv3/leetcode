class Solution {
    int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        int[] discovery = new int[n];
        int[] low = new int[n];
        
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, adjlist, discovery , low, bridges);
        
        return bridges;
    }
    
    void dfs(int node, int parent, boolean[] visited, List<List<Integer>> adjlist, int[] discovery, int[] low, List<List<Integer>> bridges){
        
        visited[node] = true;
        timer  = timer+1;
        discovery[node] = timer;
        low[node] = timer;
        
        for(int neigh : adjlist.get(node)){
            if(neigh == parent){
                continue;
            }
            
            if(visited[neigh] == false){
                dfs(neigh, node , visited, adjlist, discovery, low, bridges);
                low[node] = Math.min(low[neigh], low[node]);
                if(low[neigh] > discovery[node]){
                    ArrayList<Integer> list = new ArrayList<>(); list.add(neigh); list.add(node);
                    bridges.add(list);
                }
            }else{
                low[node] = Math.min(low[neigh], low[node]);
            }
        }
        
    }
}