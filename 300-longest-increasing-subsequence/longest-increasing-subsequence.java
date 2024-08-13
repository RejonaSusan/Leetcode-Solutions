class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n+1];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        return ans(nums, 0, -1, dp);
    }

    public int ans(int arr[], int id, int prev, int dp[][]){
        if(id == arr.length){
            return 0;
        }

        if(dp[id][prev+1] != -1){
            return dp[id][prev+1];
        }

        int notake = ans(arr, id+1, prev, dp);
        int take = 0;
        if(prev == - 1 || arr[id]>arr[prev]){
            take = 1 + ans(arr, id+1, id, dp);
        }

        return dp[id][prev+1] = Math.max(take, notake);
    }
}