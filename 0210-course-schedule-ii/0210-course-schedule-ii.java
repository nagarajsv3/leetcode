class Solution {
    public int[] findOrder(int numCourses, int[][] prereqs) {
        //prereq[v][u] - directed    
        //Create AdjList
        List<List<Integer>> adjlist  = new ArrayList<>();
        for(int i=0 ; i< numCourses ; i++){
            adjlist.add(new ArrayList<>());
        }
        
        //create in degree array & updates adjlist
        int[] inarr = new int[numCourses];

        for(int i=0; i< prereqs.length; i++){
            adjlist.get(prereqs[i][1]).add(prereqs[i][0]);
            inarr[prereqs[i][0]] = inarr[prereqs[i][0]] + 1;
        }
        
        //Add item with 0 to Q
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i< numCourses ; i++){
            if(inarr[i] ==0){
                queue.offer(i);
            }
        }
        
        int cnt = 0;
        int[] output= new int[numCourses];
        int m=0;
        while(! queue.isEmpty()){
            int node = queue.poll();
            output[m++] = node;
            cnt++;
            
            for(int neigh : adjlist.get(node)){
                if(inarr[neigh] != 0){
                    inarr[neigh] = inarr[neigh] - 1;
                    if(inarr[neigh] == 0){
                        queue.offer(neigh);
                    }
                }
            }
        }
        
        return cnt == numCourses  ? output : new int[]{}; 
    }
}