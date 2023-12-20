class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int len = grid.length;
        int arrlen = len*len;
        
        int[] arr = new int[arrlen+1];
        int missing = 0;
        int dup = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j< grid[0].length; j++){
                int val = grid[i][j];
                arr[val] = arr[val] + 1;            
                if(arr[val] ==2){
                    dup = val;
                }
            }
        }
        
        for(int m=1;m<arr.length;m++){
            if(arr[m] ==0){
                missing = m; break;
            }
        }
        
        int[] op = new int[2];
        op[0] = dup;
        op[1] = missing;
        return op;    
    }
}