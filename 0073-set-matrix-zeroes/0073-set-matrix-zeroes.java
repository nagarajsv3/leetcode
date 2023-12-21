class Solution {
    public void setZeroes(int[][] matrix) {
        //1st iterate to populate lookup rows & columns
        boolean row = true;
        boolean col = true;
        
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        
        for(int i=0;i<rowlen ; i++){  // 0 to 2
            for(int j=0;j<collen ; j++){ // 0 to 2
                if(i==0 && matrix[0][j] == 0){
                    row = false;
                }
                if(j==0 && matrix[i][0] == 0){
                    col = false;
                }
                
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        
        //set zeros from bottom up
        for(int m = rowlen-1; m>=1;m--){
            for(int n=collen-1 ; n>=1 ; n--){
                if(matrix[0][n] ==0 || matrix[m][0] ==0){
                    matrix[m][n] = 0;
                }
            }
        }
        
        print(matrix);

        
        if(row==false){
            for(int i=0;i<=0;i++){
                for(int j=collen-1 ; j>=0 ; j--){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(col == false){
            for(int i=0; i<=rowlen-1 ; i++){
                for(int j=0; j<=0; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        
    }
    
    void print(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length ; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }
}