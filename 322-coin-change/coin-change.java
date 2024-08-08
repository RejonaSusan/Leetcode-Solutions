class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        int res = ans(coins, amount, n-1, dp);

        if(res == (int)Math.pow(10, 9)){
            return -1;
        }

        return res;
    }

    public int ans(int arr[], int T, int id, int dp[][]){

        if(id == 0){
            if(T%arr[0] == 0){
                return T/arr[0];
            }else{
                return (int)Math.pow(10, 9);
            }
        }

        if(dp[id][T] != -1){
            return dp[id][T];
        }

        int notake = ans(arr, T, id-1, dp);
        int take = Integer.MAX_VALUE;
        if(arr[id]<=T){
            take = 1 + ans(arr, T-arr[id], id, dp);
        }

        return dp[id][T] = Math.min(take, notake);
    }
}