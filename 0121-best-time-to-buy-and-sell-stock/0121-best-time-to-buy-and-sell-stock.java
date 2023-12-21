class Solution { //7,1,5,3,6,4
    public int maxProfit(int[] prices) {
        int minSt = prices[0]; //7 //1 //1
        int maxPf = 0;         //0 //0
        int curPr = 0;        
        for(int i=1; i<prices.length; i++){    //i=1   i1
            curPr = prices[i] - minSt;         //-6       4   2            5
            maxPf = Math.max(maxPf, curPr);    //(0,-6)=0 4   (4,2)4 (4,5)5
            minSt = Math.min(minSt, prices[i]);//(7,1)=1  (1,5) 1 (1,3)1  (1,5)1
        }
        return maxPf;
    }
    
    //TC O(N)
    //SC O(1)
}