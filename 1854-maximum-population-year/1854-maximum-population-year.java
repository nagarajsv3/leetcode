class Solution {
    public int maximumPopulation(int[][] logs) {
        int firstBirthYear = Integer.MAX_VALUE;
        int lastDeathYear = Integer.MIN_VALUE;

        //Compute First Birth Year and Last Birth Year
        for(int i = 0;i<logs.length; i++){
            firstBirthYear = Math.min(logs[i][0], firstBirthYear);
            lastDeathYear = Math.max(logs[i][1], lastDeathYear);
        }

        //Create int array for prefix sum
        int[] yearPop = new int[lastDeathYear - firstBirthYear + 1];
        for(int i = 0;i<logs.length; i++){
            yearPop[logs[i][0] - firstBirthYear] +=  1 ;
            yearPop[logs[i][1] - firstBirthYear] +=  - 1 ; 
        }

        //Calculate Prefix SUm
        int maxYear = 0;
        int maxPop = yearPop[0];
        for(int j = 1; j<yearPop.length ; j++){
            yearPop[j] = yearPop[j] + yearPop[j-1];
            if(maxPop < yearPop[j]){
                maxPop = yearPop[j];
                maxYear = j ;
            } 
        }
        return maxYear + firstBirthYear;
    }

    //TC O(N)
    //SC O(N)
}