class Solution {
    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> adjList = getAdjacencyListFromMatrix(isConnected);
        boolean[] isvisited  = new boolean[isConnected.length];
        int counter = 0;

        for (int i=0; i<isvisited.length ; i++){
            if(isvisited[i] == false){
                counter++;
                dfs(i , isvisited, adjList );
            }
        }
    
        return counter;
    }

    void dfs(int node, boolean[] isvisited, ArrayList<ArrayList<Integer>> adjList){
        isvisited[node] = true;

        ArrayList<Integer> neighs = adjList.get(node);
        for(int neigh : neighs ){
            if(isvisited[neigh] == false){
                dfs(neigh, isvisited, adjList);
            }
        }
    }

    ArrayList<ArrayList<Integer>> getAdjacencyListFromMatrix(int[][] isConnected){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        
        int vertices = isConnected.length;

        for(int m=0; m< vertices; m++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                if(isConnected[i][j] ==1 && (i!=j)){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            } 
        }

        return adjList;
    }


    
}