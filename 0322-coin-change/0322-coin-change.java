class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //Edge Case amount 0
        if(amount ==0 ){ return 0;}
        
        //Edge Case amount less than 0
        if(amount < 0 ){ return -1;}

        //amount - 3
        //coins [2]
        //dp [0, 4, 4, 4] 
        
        int[] dp = new int[amount+1];//
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        
        Arrays.sort(coins); //3
        
        for(int money = 1 ; money<=amount ; money++){            
            for(int coin : coins){
                if(money-coin >=0){
                    dp[money] = Math.min(dp[money], dp[money-coin] + 1);
                }else{
                    break;
                } 
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}