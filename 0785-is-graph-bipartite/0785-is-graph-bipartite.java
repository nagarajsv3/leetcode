class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        
        int[] color = new int[len];
        Arrays.fill(color, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<len; i++){
            if(color[i] ==-1){
                queue.offer(i);
                color[i] = 0;
                
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    
                    int[] neighbours = graph[node];
                    
                    for(int neigh : neighbours){
                        if(color[neigh] == -1){
                            queue.offer(neigh);
                            color[neigh] = 1 - color[node];
                        }else{
                            if(color[neigh] == color[node]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}