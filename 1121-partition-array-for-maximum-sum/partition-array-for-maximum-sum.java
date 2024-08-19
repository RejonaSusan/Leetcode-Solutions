class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int dp[] = new int[n+1];

        for(int i = n-1; i>=0; i--){

            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxsum = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(i+k, n); j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len*maxi + dp[j+1];
                maxsum = Math.max(maxsum, sum);
            }

            dp[i] = maxsum;
        }

        return dp[0];
    }
}