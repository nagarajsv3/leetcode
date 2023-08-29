package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.sortingandsearching;

import java.math.*;

public class FirstBadVersionMain extends VersionControl {
    public int firstBadVersion(int n) {

        if(n==1){
            return isBadVersion(n) ? n : -1;
        }else{
            int begin  = 1;
            int end = n;

            return isBadVersionRange(begin, end);

        }

    }



    int getMidValue(int begin, int end){
        BigInteger beginBig = BigInteger.valueOf(begin);
        BigInteger endBig = BigInteger.valueOf(end);
        BigInteger sum = beginBig.add(endBig);
        BigInteger midBig = sum.divide(BigInteger.valueOf(2));
        return midBig.intValue();
    }

    int isBadVersionRange(int begin, int end){
        System.out.println("begin="+begin+";end="+end);
        if(end-begin > 2){

            int mid = getMidValue(begin, end);

            if(isBadVersion(mid)){
                return isBadVersionRange(begin, mid);
            }else{
                return isBadVersionRange(mid,end);
            }
        }else{
            if((end-begin) ==0 ){
                if(isBadVersion(begin)){
                    return begin;
                }

            }

            if((end-begin) ==1 ){
                if(isBadVersion(begin)){
                    return begin;
                }else if(isBadVersion(end)){
                    return end;
                }
            }

            if((end-begin) ==2 ){
                if(isBadVersion(begin)){
                    return begin;
                }else if(isBadVersion(begin+1)){
                    return begin+1;
                }else if(isBadVersion(end)){
                    return end;
                }
            }
            return -1;

        }



    }



}