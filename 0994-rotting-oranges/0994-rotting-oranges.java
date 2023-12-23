class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cntfrora = 0;

        boolean[][] visited = new boolean[m][n];

        Queue<Pair> queue = new ArrayDeque<>();
        //Count fresh oranges & move rotten oranges to queue & mark them visited
        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(grid[i][j] == 1){
                    cntfrora++;
                }else if(grid[i][j]==2){
                    queue.offer(new Pair(i, j, 0)); //0 refers to time
                    visited[i][j] = true;
                }                
            }
        }
        
        int ts =0;
        int freshrottencnt = 0;
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int t = pair.time;
            
            ts = Math.max(t, ts);
            
            
            int[] rarr = new int[]{-1, 0, 1, 0};
            int[] carr = new int[]{0, 1, 0, -1};
            for(int i=0; i<4;i++){
                int nr = r + rarr[i];
                int nc = c + carr[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n &&
                  grid[nr][nc] == 1 && visited[nr][nc]==false){
                    queue.offer(new Pair(nr, nc, t+1));
                    visited[nr][nc] = true;
                    freshrottencnt++;
                }
            }
        }
        
        return freshrottencnt != cntfrora ? -1 : ts ; 
    }
}

class Pair{
    int row;
    int col;
    int time;
    Pair(int _row, int _col, int _time){
        this.row = _row;
        this.col = _col;
        this.time = _time;
    }
}