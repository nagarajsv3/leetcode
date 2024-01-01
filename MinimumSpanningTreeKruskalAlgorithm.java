

// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    
	    List<Edge> edgelist = new ArrayList<>();
	    for(int i=0;i<edges.length;i++){
	        int[] edgearr = edges[i];
	        Edge edge = new Edge( edgearr[2], edgearr[0], edgearr[1]);
	        Edge edge2 = new Edge( edgearr[2],  edgearr[1], edgearr[0]);
	        edgelist.add(edge);
	        edgelist.add(edge2);
	    }
	    //Sort all edges
	    Comparator<Edge> comparator=(o1, o2) -> o1.weight - o2.weight;
	    edgelist.sort(comparator);
	    
	    
	    int sum = 0;
	    List<Edge> mst = new ArrayList<>();
	    
	    DisjointSet ds = new DisjointSet(V);
	    for(Edge edge : edgelist){
	        if(ds.findUParent(edge.u) != ds.findUParent(edge.v)){
	            ds.unionByRank(edge.u, edge.v);
	            sum = sum + edge.weight;
	            mst.add(edge);
	        }
	    }
	    return sum;
	}
}

class DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    DisjointSet(int nodes){
        for(int i=0;i<=nodes;i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }
    
    //1-2-3-4-5
    int findUParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp_node = findUParent(parent.get(node));
        parent.set(node, ulp_node);
        return parent.get(node);
    }
    
    void unionByRank(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        //1-2   3-4-5
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }//1-2-3  4-5   
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }//1-2 3-4  
        else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }
    
    void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        //1-2   3-4-5
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }//1-2-3  4-5    OR //1-2 3-4  
        else{
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }
    
}

class Edge{
    int weight;
    int u;
    int v;
    Edge(int _weight, int _u, int _v){
        this.weight = _weight;
        this.u = _u;
        this.v = _v;
    }
    @Override
    public String toString(){
        return "(u,v,weight)("+ this.u+" , "+this.v+","+this.weight;
    }
}
