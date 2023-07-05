package com.nsv.jsmbaba.leetcode.topinterviewqueseasy.array.intersection;

import java.util.*;

public class IntersectionMain {

    public static void main(String[] args) {
        int[] num1={4,9,5};
        int[] num2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(num1, num2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numsmap1 = new HashMap();
        int n1 = nums1.length;
        for(int it : nums1){
            numsmap1.put(it, numsmap1.getOrDefault(it,0)+1);
        }

        Map<Integer, Integer> numsmap2 = new HashMap();
        int n2 = nums2.length;
        for(int it2 : nums2){
            numsmap2.put(it2, numsmap2.getOrDefault(it2,0)+1);
        }

        List<Integer> list = new ArrayList<>();
        if(n1>n2){
            list = getCommon(numsmap2, numsmap1);
        }else{
            list = getCommon(numsmap1, numsmap2);
        }


        return convertListToIntArray(list);

    }


    public static int[] convertListToIntArray(List<Integer> list){
        int[] common = new int[list.size()];
        int comidx = 0;

        for(Integer i : list){
            common[comidx]=i; comidx++;
        }

        return common;
    }

    public static   List getCommon(Map<Integer,Integer> map1, Map<Integer,Integer> map2){
        List list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            int element = entry.getKey();
            int elementCounter = entry.getValue();

            Integer elementCounter22 = map2.get(element);
            if(elementCounter22 != null){
                int elementCounter2 = elementCounter22;
                if(elementCounter > elementCounter2){
                    addElementXTimes(element, elementCounter2,list);
                }else{
                    addElementXTimes(element, elementCounter,list);
                }
            }




        }
        return list;

    }

    public static  void addElementXTimes(int element, int counter,List list){
        for(int i=1; i<=counter; i++){
            list.add(element);
        }
    }


}
