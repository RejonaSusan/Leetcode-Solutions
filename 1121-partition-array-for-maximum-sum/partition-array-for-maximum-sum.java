class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return ans(arr, k, 0, dp);
    }

    public int ans(int arr[], int k, int i, int dp[]){
        int n = arr.length;

        if(i == n) return 0;

        if(dp[i] != -1){
            return dp[i];
        }

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxsum = Integer.MIN_VALUE;

        for(int j = i; j < Math.min(i+k, n); j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len*maxi + ans(arr, k, j+1, dp);
            maxsum = Math.max(maxsum, sum);
        }

        return dp[i] = maxsum;
    }
}