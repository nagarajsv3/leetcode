class Solution {
    public boolean judgeCircle(String moves) {
        int[][] direction = new int[4][2];
        direction[0] = new int[]{0,1}; // Up //North
        direction[1] = new int[]{1,0}; // Right //East
        direction[2] = new int[]{0,-1}; // Down //South
        direction[3] = new int[]{-1,0}; // Left //West

        int x= 0 ; int y=0;
        int idx = 0;

        for(char ch: moves.toCharArray()){
            if(ch == 'U'){
                idx = 0;
            }else if(ch == 'R'){
                idx = 1;
            }else if(ch =='D'){
                idx= 2;
            }else{
                idx = 3;
            }

            x = x + direction[idx][0];
            y = y + direction[idx][1];

        }
        return (x==0 && y==0);
    }
}