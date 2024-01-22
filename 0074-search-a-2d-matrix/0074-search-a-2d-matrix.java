class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        int left = 0;
        int right = (rowlen*collen) - 1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            if(matrix[mid/collen][mid%collen]==target){
                return true;
            }else if(matrix[mid/collen][mid%collen] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
        
    }
}