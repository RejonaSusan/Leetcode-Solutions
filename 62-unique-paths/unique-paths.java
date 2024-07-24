class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return ans(m-1,n-1,dp);
    }

    public int ans(int row, int col, int dp[][]){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int right = ans(row, col-1, dp);
        int left = ans(row-1, col, dp);

        return dp[row][col] = right + left;
    }
}