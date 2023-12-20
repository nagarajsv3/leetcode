public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //Brian Kernighan's Algorithm
        int counter = 0;
        
        while(n!=0){
            int rmsb = n & -n;
            n = n - rmsb;
            counter++;
        }
        
        
        return counter;
    }
}