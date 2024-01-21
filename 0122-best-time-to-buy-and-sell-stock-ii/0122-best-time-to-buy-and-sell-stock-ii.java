class Solution {
    public int maxProfit(int[] prices) {
        int maxpr = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxpr += prices[i]-prices[i-1];
            }
        }
        return maxpr;
    }
}