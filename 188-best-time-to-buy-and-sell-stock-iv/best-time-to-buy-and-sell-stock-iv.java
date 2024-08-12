class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // int dp[][][] = new int[n+1][2][k+1];

        int curr[][] = new int[2][k+1];
        int after[][] = new int[2][k+1];

        int op1 = 0, op2 = 0;

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                for(int l = 1; l<=k; l++){
                    if(j == 0){
                        op1 = after[0][l];
                        op2 = after[1][l] - prices[i];
                    }
                    if(j == 1){
                        op1 = after[1][l];
                        op2 = after[0][l-1] + prices[i];
                    }

                    curr[j][l] = Math.max(op1, op2);
                }
            }
            after = curr;
        }

        return after[0][k];

    }
}