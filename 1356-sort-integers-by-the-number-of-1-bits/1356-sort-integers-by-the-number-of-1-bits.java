class Solution {
    Comparator<Integer> comparator = new Comparator<Integer>(){
        @Override
        public int compare(Integer num1, Integer num2){
                return Integer.bitCount(num1) != Integer.bitCount(num2) 
                    ? Integer.bitCount(num1) - Integer.bitCount(num2)
                    : num1 - num2;            
        }
    };

    public int[] sortByBits(int[] arr) {
        Integer[] boxedIntArr = new Integer[arr.length];
        for(int i=0; i<arr.length; i++){
            boxedIntArr[i] = arr[i];
        }
        
        Arrays.sort(boxedIntArr,comparator);
        System.out.println(Arrays.toString(arr));

        int[] unboxedIntArr = new int[boxedIntArr.length];
        for(int i=0; i<boxedIntArr.length; i++){
            unboxedIntArr[i] = boxedIntArr[i];
        }
        return unboxedIntArr;
    }
}