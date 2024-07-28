class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
        }
        
        if(sum % 2 != 0){
            return false;
        }
        int k = sum/2;

        int dp[][] = new int[n][k+1];
        for(int r[]: dp){
            Arrays.fill(r, -1);
        }

        return ans(nums, n-1, k, dp);
    }

    public boolean ans(int nums[], int id, int sum, int dp[][]){
        if(id == 0){
            return nums[0] == sum;
        }

        if(sum == 0){
            return true;
        }

        if(dp[id][sum] != -1){
            return dp[id][sum] == 1;
        }

        boolean nopick = ans(nums, id-1, sum, dp);
        boolean pick = false;

        if(nums[id] <= sum){
            pick = ans(nums, id-1, sum-nums[id], dp);
        }

        dp[id][sum] = nopick || pick ? 1 : 0;
        
        return nopick || pick;
    }
}