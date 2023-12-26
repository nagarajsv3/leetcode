//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    //Create Adjacency list
	    List<List<List<Integer>>> adjlist = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adjlist.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length; i++){
	        int[] edge = edges[i];
	        int u = edge[0];
	        int v = edge[1];
	        int w = edge[2];
	        List<Integer> vallist = new ArrayList<>();
	        vallist.add(v);
	        vallist.add(w);
	        adjlist.get(u).add(vallist);
	        
	        List<Integer> vallist2 = new ArrayList<>();
	        vallist2.add(u);
	        vallist2.add(w);
	        
	        adjlist.get(v).add(vallist2);
	    }
	    
	    int sum = 0;
	    List<Pair> mst = new ArrayList<>();

	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.weight- y.weight);
	    pq.offer(new Pair(0,0,-1));
	    
	    boolean[] visited = new boolean[V];
	    
	    while(!pq.isEmpty()){
	        Pair minpolled = pq.poll();
	        int weight = minpolled.weight ;
	        int node = minpolled.node ;
	        int parent = minpolled.parent ;
	        
	        if(visited[node]==true){
	            continue;
	        }
	        
	        visited[node] = true;
	        
	        if(parent != -1){
	            sum = sum+weight;
	            mst.add(new Pair(0, parent,node));
	        }
	        
	        //adjacents
	        List<List<Integer>> adjacents = adjlist.get(node);
	        for(List<Integer> adjacent : adjacents){
	            int adjnode = adjacent.get(0);
	            int adjweight = adjacent.get(1);
	            
	            if(visited[adjnode] ==false){
	                pq.offer(new Pair(adjweight, adjnode, node));
	            }
	        }
	    }

	    return sum;
	}
}

class Pair{
    int weight;
    int node;
    int parent;
    Pair(int _weight, int _node, int _parent){
        this.weight = _weight;
        this.node = _node;
        this.parent = _parent;
    }
    @Override
    public String toString(){
        
        System.out.println(this.node + " "+ this.parent);
        return this.node + " "+this.parent;
    }
}