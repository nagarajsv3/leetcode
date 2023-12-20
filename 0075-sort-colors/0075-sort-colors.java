class Solution {
    
    //Dutch National Flag 3 Pointer Approach low, mid, high
    public void sortColors(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else if(nums[mid] ==2){
                swap(nums , high, mid);
                high--;
            }
        }
    }
    //TC O(N)
    //SC O(1)

    void swap(int[] nums, int fir , int sec){
        int temp = nums[fir];
        nums[fir] = nums[sec];
        nums[sec] = temp;
    }

    //Counting Sort
    /* 
    public void sortColors(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }

        int k=0;
        for(; freqMap.containsKey(0) && k<freqMap.get(0) ; k++){
            nums[k] = 0;
        }

        for(int l=0; freqMap.containsKey(1) && l<freqMap.get(1) ; l++, k++){
            nums[k] = 1;
        }

        for(int m=0; freqMap.containsKey(2) && m<freqMap.get(2) ; m++, k++){
            nums[k] = 2;
        }
    }*/
    //TC - O(N)
    //SC - O(N) 
}