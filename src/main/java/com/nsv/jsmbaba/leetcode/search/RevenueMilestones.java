package com.nsv.jsmbaba.leetcode.search;

public class RevenueMilestones {


    // Add any helper functions you may need here

    //int revenues_2[] = {700, 800, 600, 400, 600, 700};
    //int milestones_2[] = {3100, 2200, 800, 2100, 1000};


    //int revenues_1[] = {100, 200, 300, 400, 500};
    //int milestones_1[] = {300, 800, 1000, 1400};
    //int expected_1[] = {2, 4, 4, 5};

    int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here


        //Get TotalRevenue
        int[] totalRevenue = getTotalRevenue(revenues);

        //Get Milestone days using modified binary search
        int[] milestonedays = getMilestonedaysFinal(totalRevenue, milestones);
        System.out.print("Revenue= ");print(revenues);
        System.out.print("TotalRevenue= ");print(totalRevenue);
        System.out.print("Milestones= ");print(milestones);
        System.out.print("Milestone days= ");print(milestonedays);
        return milestonedays;

    }

    public int[]  getTotalRevenue(int[] revenues){
        int[] totalRevenue = new int[revenues.length];
        int total = 0;
        for(int i= 0 ; i< revenues.length ; i++){
            total += revenues[i];
            totalRevenue[i] = total;
        }
        print(totalRevenue);
        return totalRevenue;


    }

    void print(int[] arr){

        System.out.println();

        System.out.print("[");
        for(int each : arr){
            System.out.print(each +" , ");
        }
        System.out.print("]");
        System.out.println();
    }

    int[]  getMilestonedaysFinal(int[] totalRevenue, int[] milestones){
        int[] milestonedays = new int[milestones.length];
        for(int i=0; i < milestones.length; i++){
            int day = getMilestoneday(totalRevenue, milestones[i], 0, (totalRevenue.length)-1, -1);
            milestonedays[i] = (day == -1) ? -1 : day+1;
        }

        return milestonedays;
    }

    //int revenues_1[] = {100, 200, 300, 400, 500};
    //total revenues_1[] = [100, 300 , 600 , 1000 , 1500]
    //int milestones_1[] = {300, 800, 1000, 1400};
    //int expected_1[] = {2, 4, 4, 5};

    int getMilestoneday(int[]  totalRevenue, int target, int left, int right, int currentbest){

        if(left > right){
            return currentbest;
        }

        int mid = (left+right)/2;
        if(totalRevenue[mid] < target ){
            return getMilestoneday(totalRevenue,target, mid+1, right, currentbest);
        }else{
            currentbest = mid;

            return getMilestoneday(totalRevenue,target, left, mid-1, currentbest);
        }

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        check(expected_1, output_1);

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RevenueMilestones().run();
    }
}