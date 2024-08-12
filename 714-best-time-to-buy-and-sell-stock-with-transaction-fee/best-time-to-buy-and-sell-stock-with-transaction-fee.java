class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int dp[][] = new int[n+1][2];

        int op1 = 0, op2 = 0;

        for(int i = n-1; i>= 0; i--){
            for(int j = 0; j<=1; j++){
                if(j == 0){
                    op1 = dp[i+1][0];
                    op2 = dp[i+1][1] - prices[i];
                }
                if(j == 1){
                    op1 = dp[i+1][1];
                    op2 = dp[i+1][0] + prices[i] - fee;
                }
                dp[i][j] = Math.max(op1, op2);
            }
        }

        return dp[0][0];
    }
}