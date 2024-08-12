class Solution {
    public int maxProfit(int[] arr) {

        int n = arr.length;
        int dp[][] = new int[n+1][2];

        int curr[] = new int[2];
        int after[] = new int[2];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        dp[n][0] = dp[n][1] = 0;

        int op1 = 0, op2 = 0;

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                if(j == 0){
                    op1 = after[0];
                    op2 = -arr[i] + after[1];
                }

                if(j == 1){
                    op1 = after[1];
                    op2 = after[0] + arr[i];
                }

                curr[j] = Math.max(op1, op2);
            }
            after = curr;
        }

        return curr[0];
        
    }
}