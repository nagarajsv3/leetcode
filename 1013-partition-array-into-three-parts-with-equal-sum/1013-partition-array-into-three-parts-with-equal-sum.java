class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for(int i=0; i<arr.length ; i++){
            total = total + arr[i];
        }

        if(total % 3 != 0){
            return false;
        }else{
            int subarrsum = 0; 
            int counter = 0;
            for(int i=0; i<arr.length; i++){
                subarrsum = subarrsum + arr[i];
                if(subarrsum == total/3){
                    subarrsum = 0;
                    counter++;
                }
            }

            return (counter>=3) ;
        }
    }

    //TC - O(N)
    //SC - O(1)
}