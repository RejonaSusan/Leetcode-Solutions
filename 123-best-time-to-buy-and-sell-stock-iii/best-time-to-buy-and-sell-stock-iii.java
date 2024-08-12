class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][][] = new int[n+1][2][3];

        int op1 = 0, op2 = 0;

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<2; j++){
                for(int k = 1; k<=2; k++){
                    if(j == 0){
                        op1 = dp[i+1][0][k];
                        op2 = dp[i+1][1][k] - prices[i];
                    }
                    if(j == 1){
                        op1 = dp[i+1][1][k];
                        op2 = dp[i+1][0][k-1] + prices[i];
                    }
                    dp[i][j][k] = Math.max(op1, op2);
                }
            }
        }

        return dp[0][0][2];
    }
}