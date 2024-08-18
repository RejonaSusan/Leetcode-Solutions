class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: nums){
            arr.add(i);
        }

        int dp[][] = new int[n+2][n+2];
        for(int r[] : dp){
            Arrays.fill(r, 0);
        }

        arr.add(1);
        arr.add(0, 1);

        for(int i = n; i>=1; i--){
            for(int j = 1; j<=n; j++){
                if(i>j) continue;

                int maxi = Integer.MIN_VALUE;

                for(int k = i; k <= j; k++){
                    int res = arr.get(i-1)*arr.get(k)*arr.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi, res);
                }
                dp[i][j] = maxi;
                
            }
        }

        return dp[1][n];
    }
}