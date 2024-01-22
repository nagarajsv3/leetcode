class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int cnt = 0;
        
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    bfs(i,j, visited, grid, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    void bfs(int row, int col, boolean[][] visited, char[][] grid, int m, int n){
    Queue<Pair> q = new ArrayDeque<>();
    q.offer(new Pair(row, col));
    visited[row][col] = true;
    
    while(!q.isEmpty()){
        Pair polPair = q.poll();
        int prow = polPair.row;
        int pcol = polPair.col;
        
        //visit 4 neigh
        //1 (0,1)
        int uprow1 = prow+0 > m-1 ? Integer.MAX_VALUE : prow+0;;
        int upcol1 = (pcol+1) > n-1 ? Integer.MAX_VALUE : pcol+1;
        if(uprow1!=Integer.MAX_VALUE && upcol1 !=Integer.MAX_VALUE){
            if(grid[uprow1][upcol1] == '1' && visited[uprow1][upcol1] == false){
                q.offer(new Pair(uprow1, upcol1));
                visited[uprow1][upcol1]=true;
            }
        }
        
        //2 (1,0)
        int uprow2 = prow+1 > m-1 ? Integer.MAX_VALUE : prow+1;;
        int upcol2 = (pcol+0) > n-1 ? Integer.MAX_VALUE : pcol+0;
        if(uprow2!=Integer.MAX_VALUE && upcol2 !=Integer.MAX_VALUE){
            if(grid[uprow2][upcol2] == '1' && visited[uprow2][upcol2] == false){
                q.offer(new Pair(uprow2, upcol2));
                visited[uprow2][upcol2]=true;
            }
        }
        
        //3 (0,-1)
        int uprow3= prow+0 > m-1 ? Integer.MAX_VALUE : prow+0;;
        int upcol3 = (pcol-1) < 0 ? Integer.MAX_VALUE : pcol-1;
        if(uprow3!=Integer.MAX_VALUE && upcol3 !=Integer.MAX_VALUE){
            if(grid[uprow3][upcol3] == '1' && visited[uprow3][upcol3] == false){
                q.offer(new Pair(uprow3, upcol3));
                visited[uprow3][upcol3]=true;
            }
        }
        //4 (-1,0)
        int uprow4= prow-1 < 0 ? Integer.MAX_VALUE : prow-1;
        int upcol4 = (pcol+0) > n-1 ? Integer.MAX_VALUE : pcol+0;
        if(uprow4!=Integer.MAX_VALUE && upcol4 !=Integer.MAX_VALUE){
            if(grid[uprow4][upcol4] == '1' && visited[uprow4][upcol4] == false){
                q.offer(new Pair(uprow4, upcol4));
                visited[uprow4][upcol4]=true;
            }
        }
        
    }
}
    
}

class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}