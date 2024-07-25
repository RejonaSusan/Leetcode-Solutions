class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int dp[][] = new int[n][n];

        for(int r[]: dp){
            Arrays.fill(r, -1);
        } 

        return ans(triangle, 0, 0, dp);
    }

    public int ans(List<List<Integer>> arr, int row, int col, int dp[][]){

        if(row == arr.size()-1){
            return arr.get(row).get(col);
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int down = arr.get(row).get(col) + ans(arr, row+1, col, dp);
        int diaganol = arr.get(row).get(col) + ans(arr, row+1, col+1, dp);

        return dp[row][col] = Math.min(down, diaganol);
    }
}