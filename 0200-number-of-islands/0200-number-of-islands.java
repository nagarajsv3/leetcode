class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int counter=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && visited[i][j] == false){
                    System.out.println("Starting from "+i+ " "+j);                
                    bfs(i, j, visited, grid);
                    counter++;
                }
            }
        }
        return counter;
    }

    void bfs(int row, int col, boolean[][] visited, char[][] grid){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int i = pair.first;
            int j = pair.second;

            
            //Explore the neighbours vertically
            int k=i-1 <= 0 ? 0 : i-1; 
            for( ; k<=(i+1) && k<visited.length; k++){
                if(grid[k][j] == '1' && visited[k][j] ==false){
                    queue.offer(new Pair(k, j));
                    visited[k][j] = true;
                }
            }

            //Explore the neighbours horizontally
            int l=j-1 <= 0 ? 0: j-1;
            for( ; l<=(j+1) && l<visited[0].length; l++){
                if(grid[i][l] == '1' && visited[i][l] ==false){
                    queue.offer(new Pair(i, l));
                    visited[i][l] = true;
                }
            }

        }
    }
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}