import java.math.*;
class Solution {
    public int mySqrt(int x) {
        
        if(x ==0 ){
            return 0;
        }else if(x ==1){
            return 1;
        }

        //Binary Search In the Range
        int bestnumber = 0;
        bestnumber = findSquareRootBinarySearch(x, 0, x/2, bestnumber);

        return bestnumber;

    }

    int findSquareRootBinarySearch(int x, int left, int right, int bestnumber){
        if (left > right){
            return bestnumber;
        }

        int mid = left + (right-left)/2;
        if(square(mid) <= x){
            bestnumber = mid > bestnumber ? mid : bestnumber;
            return findSquareRootBinarySearch(x, mid+1, right, bestnumber);
        }else{
            return findSquareRootBinarySearch(x, left, mid-1, bestnumber);
        }
    }
    

    long square(int x){
        long squ= (long) x*x;
        System.out.print("x="+x+" ;square of x="+squ);
        return squ;
    }

    
}