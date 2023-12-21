class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        transpose(matrix);
        //reverse each row
        reverseeachrow(matrix);
    }
    
    void transpose(int[][] matrix){
        for(int i=0; i<matrix.length-1; i++){
            for(int j=i+1 ; j<matrix.length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    void reverseeachrow(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0, k=matrix.length-1; j<=k; j++, k--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}