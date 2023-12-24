class Solution {
    public boolean canFinish(int numCourses, int[][] prereqs) {
        //Topological Sort - BFS
        //Create Adjacency List using Prereq
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<numCourses ; i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int i=0; i<prereqs.length ; i++){
            int v = prereqs[i][0];
            int u = prereqs[i][1];
            adjlist.get(u).add(v);
        }
        
        //Create In degree counter array
        int[] inarr = new int[numCourses];
        for(int i=0;i<numCourses ; i++){
            for(int each : adjlist.get(i)){
                inarr[each] = inarr[each] + 1; 
            }
        }
        
        //Push item with indegree ==0 to Q
        Queue<Integer> queue = new ArrayDeque<>();
        for(int j=0; j<numCourses ; j++){
            if(inarr[j] == 0){
                queue.offer(j);
            }
        }
        
        int[] output = new int[numCourses];
        int cnt = 0;
        int k=0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            output[k++] = node; 
            cnt++;
            
            for(int each : adjlist.get(node)){
                if(inarr[each] != 0){
                    inarr[each] = inarr[each] -1;
                    if(inarr[each] == 0){
                        queue.offer(each);
                    }
                }
            }
        }
            
        return cnt == numCourses ? true : false;
    }
}