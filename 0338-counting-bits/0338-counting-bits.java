class Solution {
    public int[] countBits(int n) {

        int[] setbitcountarr = new int[n+1];
        for(int i=0; i<=n ; i++ ){
            setbitcountarr[i] = countBit(i);
        }
        return setbitcountarr;
    }

//Brian Kerninghams algorithm
    int countBit(int num){
        int counter = 0 ;
        while(num!=0){
            int rmsb = num & -num; //right most set bit
            num = num - rmsb;
            counter++;
        }

        return counter;
    }
}