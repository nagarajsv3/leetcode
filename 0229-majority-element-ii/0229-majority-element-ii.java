class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        int ele1 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int ele2 = Integer.MIN_VALUE;
        int cnt2 = 0;
        for(int i=0;i<nums.length; i++){
            if(ele1 == nums[i]){
                cnt1++;    
            }else if(ele2 ==nums[i]){
                cnt2++;
            }else if(cnt1==0){
                ele1 = nums[i];
                cnt1++;
            }else if(cnt2==0){
                ele2 = nums[i];
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        int num1cnt = 0;
        int num2cnt = 0;
        for(int i=0;i<nums.length ; i++){
            if(ele1!= Integer.MIN_VALUE && nums[i] == ele1){
                num1cnt++;
            }
            if(ele2!= Integer.MIN_VALUE && nums[i] == ele2){
                num2cnt++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if(num1cnt > nums.length/3){
            list.add(ele1);
        }
        if(num2cnt > nums.length/3){
            list.add(ele2);
        }
        return list;

    }
    
    //TC O(N)
    //SC O(1)
}