class Solution {
    public boolean isBipartite(int[][] graph) {
        int verlen =  graph.length;
        int[] color = new int[verlen] ;
        Arrays.fill(color, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0;i<verlen;i++){
            if(color[i] == -1){
                queue.offer(i);
                color[i] = 0;
                
                while(! queue.isEmpty()){
                int node = queue.poll();

                //color its neighbours
                for(int neigh : graph[node]){
                    if(color[neigh] == -1){
                        queue.offer(neigh);
                        color[neigh] = 1 - color[node];
                    }else if(color[neigh] == color[node]){
                        return false;
                    }
                }
        }
            }
        }
        
        
        
        return true;
    }
}