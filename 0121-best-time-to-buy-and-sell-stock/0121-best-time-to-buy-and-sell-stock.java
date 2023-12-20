class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStockPrice = prices[0];

//7,1,5,3,6,4
        for(int i=1; i< prices.length; i++){
            //Is it the best profit
            int currentprofit = prices[i]- minStockPrice ;
            maxProfit = Math.max(maxProfit, currentprofit);

            //Is It the Best All time low
            minStockPrice = Math.min(minStockPrice, prices[i]);        

        }
        return maxProfit;
    }
}