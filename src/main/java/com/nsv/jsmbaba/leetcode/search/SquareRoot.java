package com.nsv.jsmbaba.leetcode.search;

public class SquareRoot {

    public int mySqrt(int x) {

        System.out.println("*************************************************************Input="+x);
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
        System.out.print("num="+x+" ;square of num=num*num="+squ+"\t");
        System.out.println("");
        return squ;
    }

    public static void main(String[] args) {

        new SquareRoot().run();
    }

    private void run() {

        System.out.println("RightTick="+'\u2713');
        System.out.println("WrongTick="+'\u2717');
        check(1, 0,(0));
        check(2, 1,(1));
        check(3, 1,(2));
        check(4, 2,(5));
        check(5, 2,(4));
        check(6, 3,(9));
        check(7, 4,(16));
        check(8, 4,(17));
        check(9, 46056,(2121212121));


    }

    private void check(int testcasenumber, int expected, int input) {
        char right = '\u2713';
        char wrong = '\u2717';
        if(expected == mySqrt(input)){
            System.out.println("Test case="+testcasenumber+ "result="+right);
        }else{
            System.out.println("Test case="+testcasenumber+ "result="+wrong);
        }
    }

}
