class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<edges.length;i++){
            ds.unionByRank(edges[i][0], edges[i][1]);            
        }

        return ds.findUParent(source) == ds.findUParent(destination);
        
    }
    
    
}

class DisjointSet{
    
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    DisjointSet(int nodes){
        for(int i=0;i<=nodes ; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    // 1- 2 - 3 - 4 - 5
    int findUParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        //Path Compression
        int ulp_node = findUParent(parent.get(node));
        parent.set(node, ulp_node);
        return parent.get(node);
    }

    //1-2  4-5-6-7
    //2 , 7
    void unionByRank(int u, int v){
        //Get Ultimate Parent of u & v
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        //COmpare Ranks of Ultimate Parent of u and v
        if(ulp_u == ulp_v){
            return;
        }
        //Attach Smaller component to bigger and update parent and size
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else{
            //Rank gets updated only if both parents are at same rank
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }

    }

    //1-2   3-4

    //1-2-3-4  5-6-7-8-9
    //4,9
    void unionBySize(int u , int v){
        //Get Ultimate Parent of u & v
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v){
            return ;
        }

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v)+ size.get(ulp_u));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+ size.get(ulp_v));
        }


    }
    
}