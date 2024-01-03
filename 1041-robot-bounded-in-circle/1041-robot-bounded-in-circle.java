class Solution {
    public boolean isRobotBounded(String instructions) {
        int idx = 0;
        int[][] direction = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        
        for(int i=0; i<instructions.length(); i++){
            char ins = instructions.charAt(i);
            if(ins == 'R'){
                idx = (idx+1)%4;
            }else if(ins == 'L'){
                idx  = (idx + 3)%4;
            }else{
                x = x + direction[idx][0];
                y = y + direction[idx][1];
            }
            
        }
        
        if((x==0 &&  y==0) || (idx!=0)){
            return true;
        }else{
            return false;
        }
    }
}