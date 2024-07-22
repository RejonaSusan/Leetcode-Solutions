class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return ans(nums, nums.length-1, dp);
    }

    public int ans(int nums[], int id, int dp[]){

        if(id < 0){
            return 0;
        }
        // if(id == 0){
        //     return nums[id];
        // }
        if(dp[id] != -1){
            return dp[id];
        }
        
        int notpick = ans(nums, id-1, dp);
        int pick = nums[id] + ans(nums, id-2, dp);

        return dp[id] = Math.max(pick, notpick);
    }
}