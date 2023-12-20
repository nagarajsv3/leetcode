class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> fM = new HashMap<Integer, Integer>();
        for(int i=0; i<nums2.length; i++){
            fM.put(nums2[i], fM.getOrDefault(nums2[i], 0)+1);
        }

        int[] output = new int[nums1.length];

        int k=0;
        for(int i=0;i<nums1.length ; i++){
            if(fM.containsKey(nums1[i])){
                output[k++] = nums1[i];
                fM.remove(nums1[i]);
            }
        }
        return Arrays.copyOfRange(output, 0, k);

        //TC - O(M+N)
        //SC - O(M)

    }
}