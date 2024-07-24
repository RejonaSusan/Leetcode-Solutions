class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) {
            return 0;
        }

        int dp[][] = new int[row][col];

        for(int r[]: dp){
            Arrays.fill(r, -1);
        }

        return ans(obstacleGrid, row-1, col-1, dp);
    }

    public int ans(int[][] arr, int row, int col, int dp[][]){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0 || arr[row][col] == 1){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int up = ans(arr, row-1, col, dp);
        int left = ans(arr, row, col-1, dp);
        
        return dp[row][col] = up + left;
    }
}