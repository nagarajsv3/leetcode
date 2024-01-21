class Solution {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergesort(0, nums.length-1 , nums);
        System.out.println(Arrays.toString(nums));
        return count;
    }
    
    void mergesort(int begin, int end , int[] nums){
        if(end-begin<=0){
            return;
        }
        int mid = (begin+end)/2;
        mergesort(begin, mid, nums);
        mergesort(mid+1, end, nums);
        countinversions(begin, mid+1, end, nums);
        mergeback(begin, mid+1, end, nums);
    }
    
    void countinversions(int left, int right, int end, int[] nums){
        int leftend = right-1;
        int j=right;
        for(int i=left;i<=leftend; i++){
            while(j<=end && (((long)nums[i]) > ((long)2*nums[j]))){
                j++;
            }
            count += (j-right);   
        }
    }
    
    void mergeback(int left, int right, int end, int[] nums){
        int leftend = right-1;
        int i = left;
        int j= right;
        int[] temp = new int[end-left+1];
        int k=0;
        while(i<=leftend && j<=end){
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        
        while(i<=leftend && j>end){
            temp[k++] = nums[i++];
        }
        while(i>leftend && j<=end){
            temp[k++] = nums[j++];
        }
        
        for(int m=0, n=left ;m<temp.length;){
            nums[n++] = temp[m++];
        }
    }
}