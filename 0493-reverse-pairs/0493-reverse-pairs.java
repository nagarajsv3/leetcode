class Solution {

    public int reversePairs(int[] nums) {
        int count = mergeSort(nums, 0, nums.length-1);//1 3 2 3 1 //0, 4
        return count;
    }

    int mergeSort(int[] nums, int begin, int end){ //{1,3,2,3,1} //0,4
        int count = 0;
        if(end-begin<=0){
             return count;
        }

        int mid = (begin + end)/2;//2
        count += mergeSort(nums, begin, mid);//0, 2 // 0, 1
        count += mergeSort(nums, mid+1, end);
        count += countReversePairs(nums, begin, mid+1, end);
        mergeBack(nums, begin, mid+1, end);
        return count;
    }

    int countReversePairs(int[] nums, int left, int right, int end){
        int count =0 ;
        int leftend = right-1;
        int j=right;
        for(int i=left; i<=leftend; i++){
            while (j<=end && ((long)nums[i]  > 2 * (long)nums[j])){    
                j++;
            }
            count = count + (j - right);
        }
        return count;
    }

    void mergeBack(int[] nums, int leftOri, int rightOri, int end){
        int left = leftOri;
        int right = rightOri;
        
        int leftend = right-1;

        int[] temp = new int[end-left+1];
        int k=0;
        while(left<=leftend && right<=end){
            if(nums[left] > nums[right]){
                temp[k] = nums[right];
                k++;
                right++;
            }else{
                temp[k] = nums[left];
                k++;
                left++;
            }
        }

        while(left<=leftend && right>end){
            temp[k] = nums[left];
            k++;
            left++;
        }

        while(left>leftend && right<=end){
            temp[k] = nums[right];
            k++;
            right++;
        }


        int m=0;
        for(int n=leftOri; n<=end;){
            nums[n++] = temp[m++];
        }

    }
}