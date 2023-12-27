class Solution {
    int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        int[] ins = new int[n];
        int[] low = new int[n];
        
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(List<Integer> conn : connections){
            int u = conn.get(0);
            int v = conn.get(1);
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        
        List<List<Integer>> bridges = new ArrayList<>();
        
        dfs(0, -1, visited, adjlist, ins, low, bridges);
        return bridges;
        
    }
    
    void dfs(int node , int parent, boolean[] visited, List<List<Integer>> adjlist, int[] ins, int[] low, List<List<Integer>> bridges){
        visited[node] = true;
        ins[node] = timer;
        low[node] = timer;
        timer= timer+1;
        
        for(int neigh : adjlist.get(node)){
            if(neigh == parent){
                continue;
            }
            
            if(visited[neigh] == false){
                dfs(neigh , node, visited, adjlist, ins, low, bridges);
                low[node] = Math.min(low[node], low[neigh]);
                //bridge  ancestor -- node -- neigh
                if(low[neigh] > ins[node] ){
                    //Its a bridge
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(neigh);
                    bridges.add(bridge);
                }
            
            }else{
                low[node] = Math.min(low[node], low[neigh]);
            }
        }
        
    }
}