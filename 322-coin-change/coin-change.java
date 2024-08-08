class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
    
        for(int T = 0; T<=amount; T++){
            if(T%coins[0] == 0){
                dp[0][T] = T/coins[0];
            }else{
                dp[0][T] = (int)Math.pow(10,9);
            }
        }

        for(int id = 1; id<n ; id++){
            for(int T = 0; T<=amount; T++){
                int notake = dp[id-1][T];
                int take = Integer.MAX_VALUE;
                if(coins[id]<=T){
                    take = 1 + dp[id][T-coins[id]];
                }
                dp[id][T] = Math.min(take, notake);
            }
        }

        if(dp[n-1][amount] == (int)Math.pow(10, 9)){
            return -1;
        }
        return dp[n-1][amount];
    }
}