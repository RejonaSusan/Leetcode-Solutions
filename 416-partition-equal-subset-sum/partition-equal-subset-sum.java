class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tot_sum = 0;
        for(int i =0; i<n; i++){
            tot_sum += nums[i];
        }

        if(tot_sum % 2 != 0){
            return false;
        }

        int k = tot_sum/2;
        int dp[][] = new int[n][k+1];
        for(int r[]: dp){
            Arrays.fill(r, -1);
        }
        return ans(n-1, k, nums, dp);
    }

    public boolean ans(int id, int sum, int nums[], int dp[][]){

        if(sum == 0){
            return true;
        }
        if(id == 0){
            return nums[id] == sum;
        }
        if(dp[id][sum] != -1){
            return dp[id][sum] == 0 ? false : true;
        }

        boolean nopick = ans(id-1, sum, nums, dp);
        boolean pick = false;
        if(nums[id] <= sum){
            pick = ans(id-1, sum-nums[id], nums, dp);
        }
        dp[id][sum] = nopick || pick ? 1 : 0;
        return pick || nopick;
    }
}