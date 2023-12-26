package programs.graphs.disjointset;

import java.util.ArrayList;

public class DisjointSet {

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

    public static void main(String[] args) {
        System.out.println("******Union By Rank*********");
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);

        if(ds.findUParent(3)==ds.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

        ds.unionByRank(3,7);
        System.out.println("Rank  ="+ds.rank.toString());
        System.out.println("Parent="+ds.parent.toString());
        if(ds.findUParent(3)==ds.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

        System.out.println("******Union By Size*********");
        DisjointSet ds2 = new DisjointSet(7);
        ds2.unionBySize(1,2);
        ds2.unionBySize(2,3);
        ds2.unionBySize(4,5);
        ds2.unionBySize(6,7);
        ds2.unionBySize(5,6);

        if(ds2.findUParent(3)==ds2.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

        ds2.unionBySize(3,7);
        System.out.println("Size  ="+ds2.rank.toString());
        System.out.println("Parent="+ds2.parent.toString());
        if(ds2.findUParent(3)==ds2.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

    }



}
