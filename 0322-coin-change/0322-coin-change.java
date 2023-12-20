class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount <0){
            return -1;
        }

        if(amount ==0){
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        Arrays.sort(coins);

        //Iterate through Money & populated DP table with best possible combination of coins
        for(int money = 1 ; money <= amount ; money++){

            for(int coin : coins){
                if(money-coin >=0){
                    dp[money] = Math.min(dp[money], dp[money-coin] + 1);
                }else{
                    break;
                }
            }

        }

        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}