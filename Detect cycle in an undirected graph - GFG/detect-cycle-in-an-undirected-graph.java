//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        Queue<Pair> queue = new ArrayDeque<>();
        
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                queue.offer(new Pair(i,-1));
                visited[i] = true;
                
                while(! queue.isEmpty()){
                    Pair polled = queue.poll();
                    int cur = polled.node;
                    int parent = polled.parent;
                    
                    ArrayList<Integer> neighs = adj.get(cur);
                    for(int neigh : neighs){
                        if(visited[neigh] == true ){
                            //who visited ?
                            if(neigh != parent){
                                return true;
                            }
                        }else{
                            queue.offer(new Pair(neigh, cur));
                            visited[neigh] = true;
                        }
                    }
                }
                
            }
            
                
                
        }
        return false;
    }
}

class Pair{
    int node;
    int parent;
    Pair(int _n, int _p){
        this.node = _n;
        this.parent = _p;
    }
}