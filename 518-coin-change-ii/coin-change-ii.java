class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        
        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        return ans(amount, coins, n-1, dp);
    }

    public int ans(int T, int nums[], int id, int dp[][]){
        
        if(id == 0){
            if(T % nums[0] == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[id][T] != -1){
            return dp[id][T];
        }

        int notake = ans(T, nums, id-1, dp);
        int take = 0;
        if(nums[id] <= T){
            take = ans(T-nums[id], nums, id, dp);
        }

        return dp[id][T] = notake + take;
    }
}