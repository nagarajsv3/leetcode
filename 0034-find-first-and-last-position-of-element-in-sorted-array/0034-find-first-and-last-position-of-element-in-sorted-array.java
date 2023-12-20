class Solution {
    public int[] searchRange(int[] nums, int target) {
            int[] response = new int[2];
            int lowercurrentbest= -1;
            int uppercurrentbest = -1;

        if(nums.length > 0){        
            lowercurrentbest = binarySearchLowerHelper(nums, target, 0, nums.length-1, lowercurrentbest);
            uppercurrentbest = binarySearchUpperHelper(nums, target, 0, nums.length-1, uppercurrentbest);
        }

            response[0] = lowercurrentbest;
            response[1] = uppercurrentbest;
            
            return response;

            //Time Complexity - O(log n ) + O(log n) = O(log n)
            //Space Complexity - O(1)

    }

    int binarySearchLowerHelper(int[] nums, int target, int left, int right, int currentbest){
        //[5,7,7,8,8,10]
        //0 7
        if(left > right){
            return currentbest;
        }

        int mid = left + (right-left)/2;
        
        //[5,7,7,8,8,10]
        //8 = 8
        if(nums[mid] == target){
            currentbest = mid;
            return binarySearchLowerHelper(nums, target, left, mid-1, currentbest);
        }else if(nums[mid] > target){
            return binarySearchLowerHelper(nums, target, left, mid-1, currentbest);
        }else if(nums[mid] < target){
            return binarySearchLowerHelper(nums, target, mid+1, right, currentbest);
        }

        return currentbest;
    }

    int binarySearchUpperHelper(int[] nums, int target, int left, int right, int currentbest){

        if(left > right){
            return currentbest;
        }

        int mid = left + (right-left)/2;

        if(nums[mid] == target){
            currentbest = mid;
            return binarySearchUpperHelper(nums, target, mid+1, right, currentbest);
        }else if(nums[mid] > target){
            return binarySearchUpperHelper(nums, target, left, mid-1, currentbest);
        }else if(nums[mid] < target){
            return binarySearchUpperHelper(nums, target, mid+1, right, currentbest);
        }

        return currentbest;
    }
}