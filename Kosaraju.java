

//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //Sort all edges / nodes by end execution time
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0 ; i<V ; i++){
            if(visited[i] == false){
                dfs(i, visited, adj, stack);
            }
        }
        
        //reverse the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjT.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            ArrayList<Integer> adjacents = adj.get(i);
            for(int adjacent : adjacents){
                adjT.get(adjacent).add(i);
            }
        }
        
        int sum = 0;
        boolean[] visitedrev = new boolean[V]; 
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            
            if(visitedrev[node] == false){
                sum = sum +1;
                dfs2(node, visitedrev, adjT);
            }
            
        }
        
        return sum;
        
    }
    
    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj , Stack<Integer> stack){
        visited[node] = true;
        
        for(int neigh : adj.get(node)){
            if(visited[neigh] ==false){
                dfs(neigh, visited, adj, stack);
            }
        }
        
        stack.push(node);
    }

    void dfs2(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj ){
        visited[node] = true;
        
        for(int neigh : adj.get(node)){
            if(visited[neigh] ==false){
                dfs2(neigh, visited, adj);
            }
        }
        
    }
    
}
