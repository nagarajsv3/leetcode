class Solution {
    public boolean isRobotBounded(String instructions) {

        //Limit Cycle Trajectory - In 1 or 4 cycle , it forms a cycle if direction is not initial direction after 1 pass
        //Direction array with direction ordinates  North - 0 , East - 1, South - 2 , West - 3
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x=0;
        int y=0;
        int idx = 0;

        for(int i=0; i<instructions.length(); i++){
            char ins = instructions.charAt(i);
            if(ins == 'R'){
                idx = (idx + 1) % 4;
            }else if(ins == 'L'){
                idx = (idx + 3) % 4;
            }else{
                x = x + direction[idx][0];
                y = y + direction[idx][1];
            }
        }

        if((x==0 && y==0) || idx!=0){
            return true;
        }
        return false;
    }

    //TC - O(N)
    //SC - O(1)
}