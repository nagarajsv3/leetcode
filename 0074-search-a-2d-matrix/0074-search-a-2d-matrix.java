class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        int left = 0;
        int right = rowlen * collen - 1;
        
        while(left <= right){ //0,11   6,11 //8,11
            int mid = left + (right-left)/2; //5 //8 //9
            
            if(matrix[mid/collen][mid%collen]==target){//[1,1] 11 != 30 [2,0] 23!=30 [2,1]=30 30=30
                return true;
            }else if(matrix[mid/collen][mid%collen] > target){ 
                right = mid-1;    
            }else if(matrix[mid/collen][mid%collen] < target){ //11<30   23<30
                left = mid+1;
            }
        }
        return false;
    }
    //TC O(log m*n)
    //SC O(1)
}