//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    int timer = 0;
    
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        int[] low = new int[V];
        int[] insertiontime = new int[V];
        int[] mark = new int[V];
        
        for(int i=0; i<V;i++){
            if(visited[i] == false){
                dfs(i, -1, visited, adj, low, insertiontime, mark);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int cnt=0;
        for(int i=0;i<V;i++){
            if(mark[i] == 1){
                cnt++;
                list.add(i);
            }
        }
        if(cnt>0){
            return list;
            
        }else{
            list.add(-1);
            return list;
        }
    }
    
    void dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj, 
    int[] low, int[] insertiontime, int[] mark){
        visited[node] =true;
        low[node] = timer;
        insertiontime[node] = timer;
        timer = timer+1;
        
        int child = 0;
        for(int neigh : adj.get(node)){
            if(neigh == parent){
                continue;
            }
            
            if(visited[neigh] == false){
                dfs(neigh, node, visited, adj, low, insertiontime, mark);
                low[node] = Math.min(low[node], low[neigh]);
                if(low[neigh] >= insertiontime[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
                if(child>=2 && parent==-1){
                    mark[node] = 1;
                }
            }else{
                low[node] = Math.min(low[node], insertiontime[neigh]);
            }
        }
    }
}