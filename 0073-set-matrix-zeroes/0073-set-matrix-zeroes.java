class Solution {
    public void setZeroes(int[][] matrix) {
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        
        int[] rowmark = new int[rowlen];
        int[] colmark = new int[collen];
        
        for(int i=0; i<rowlen; i++){
            for(int j=0;j<collen; j++){
                if(matrix[i][j] ==0){
                    rowmark[i] =1;
                    colmark[j] = 1;
                }
            }
        }
        
        for(int i=0; i<rowlen; i++){
            for(int j=0;j<collen; j++){
                if(rowmark[i] ==1 || colmark[j] == 1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}