//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        //return topoSortDFS(V, adj);
        
        return toposortBFS(V, adj);
    }
    
    static int[] toposortBFS(int V, ArrayList<ArrayList<Integer>> adj){
        //Create Indegree counter array
        int[] indgcnt = new int[V];
        for(int i=0; i<V;i++){
            for(int each : adj.get(i)){
                indgcnt[each] = indgcnt[each] + 1;
            }
        }
        
        //Add nodes whose indegree count is zero to q
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(indgcnt[i] == 0){
                queue.offer(i);
            }
        }
        
        //Create Output
        int[] output = new int[V];
        int k=0;
        while(! queue.isEmpty()){
            int node = queue.poll();
            output[k++] = node;
            //Cut connection from all neighbours
            for(int neigh : adj.get(node)){
                if(indgcnt[neigh] != 0){
                    indgcnt[neigh] = indgcnt[neigh]-1;
                    if(indgcnt[neigh]==0){
                        queue.offer(neigh);
                    }
                } 
            }
            
        }
        return output;
        
    }
    
    
    
    
    
    
    
    static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<V ; i++){
            if(visited[i] ==false){
                dfs(i, visited, adj, stack);
            }
            
        }
        
        //Create output linear order using stack
        int i=0;
        int[] output = new int[stack.size()];
        while(!stack.isEmpty()){
            output[i++] = stack.pop();
        }
        return output;
    }
    
    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[node] = true;
        
        //Visit Children
        for(int neigh : adj.get(node)){
            if(visited[neigh] == false){
                dfs(neigh, visited, adj, stack);
            }
        }
        
        stack.push(node);
    }
}
