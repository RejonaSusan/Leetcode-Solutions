class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tot = 0;
        int n = nums.length;

        for(int i = 0; i<n; i++){
            tot += nums[i];
        }

        if(tot - target < 0){
            return 0;
        }
        if((tot - target) % 2 == 1){
            return 0;
        }
        int T = (tot-target)/2;

        int dp[][] = new int[n][T+1];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        return ans(nums, T, n-1, dp);
    }

    public int ans(int nums[], int T, int id, int dp[][]){

        if(id == 0){
            if(T == 0 && nums[0] == 0){
                return 2;
            }
            if(T == 0 || T == nums[0]){
                return 1;    
            }
            return 0;
        }

        if(dp[id][T] != -1){
            return dp[id][T];
        }
        
        int notake = ans(nums, T, id-1, dp); 
        int take = 0;

        if(nums[id]<=T){
            take = ans(nums, T-nums[id], id-1, dp);
        }

        return dp[id][T] = (take + notake);
    }
}