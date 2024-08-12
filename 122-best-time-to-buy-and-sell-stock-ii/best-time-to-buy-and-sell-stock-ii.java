class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n+1][2];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        // dp[n][0] = dp[0][n] = 0;

        // for(int i = 0; i>)

        return ans(prices, 0, 0, dp);
        
    }
    public int ans(int arr[], int buy, int id, int dp[][]){
        if(id == arr.length){
            return 0;
        }

        if(dp[id][buy] != -1){
            return dp[id][buy];
        }

        int op1 = 0, op2 = 0;

        if(buy == 0){
            op1 = ans(arr, 0, id+1, dp);
            op2 = -arr[id] + ans(arr, 1, id+1, dp);
        }

        if(buy == 1){
            op1 = ans(arr, 1, id+1, dp);
            op2 = ans(arr, 0, id+1, dp) + arr[id];
        }

        return dp[id][buy] = Math.max(op1, op2);
    }
}