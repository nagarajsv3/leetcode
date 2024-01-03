class Solution {
    public int orangesRotting(int[][] grid) {
        int rowlen = grid.length;
        int collen = grid[0].length;
        boolean[][] visited = new boolean[rowlen][collen];
        
        int freshorangecnt = 0;
        int freshrottencnt = 0;
        
        Queue<Triplet> queue = new ArrayDeque<>();
        
        //Add Rotten Oranges to Queue
        for(int i=0; i<rowlen;i++){
            for(int j=0; j<collen ; j++){
                if(grid[i][j] == 2 && visited[i][j] == false){
                    queue.offer(new Triplet(i, j, 0));
                    visited[i][j]=true;
                }
                
                if(grid[i][j]==1){
                    freshorangecnt++;
                }
            }
        }
        
        int timer = 0;
        int maxtm = 0;
        
        while(!queue.isEmpty()){
            Triplet tripl = queue.poll();
            int row = tripl.row;
            int col = tripl.col;
            int rottentime = tripl.time;
            
            maxtm = Math.max(maxtm, rottentime);
            
            //Check its 4 neighbours
            int[] neirow = new int[]{0, 1, 0, -1};
            int[] neicol = new int[]{1, 0, -1, 0};
            for(int i=0;i<4;i++){
                int neiuprow = row + neirow[i];
                int neiupcol = col + neicol[i];
                if(neiuprow>=0 && neiuprow<rowlen &&  neiupcol>=0 && neiupcol<collen && 
                    grid[neiuprow][neiupcol] ==1 && visited[neiuprow][neiupcol] == false){
                    queue.offer(new Triplet(neiuprow, neiupcol, rottentime+1));
                    visited[neiuprow][neiupcol] = true;
                    freshrottencnt++;
                }
            }
        }
        
        return freshrottencnt==freshorangecnt ? maxtm : -1;
        
    }
}
class Triplet{
    int row;
    int col;
    int time;
    Triplet(int _row, int _col, int _time){
        this.row = _row;
        this.col = _col;
        this.time = _time;
    }
}