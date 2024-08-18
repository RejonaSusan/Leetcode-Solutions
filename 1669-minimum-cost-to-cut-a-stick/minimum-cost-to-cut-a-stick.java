class Solution {
    public int minCost(int n, int[] cuts) {

        int c = cuts.length;

        int dp[][] = new int[c+1][c+1];
        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : cuts) {
            arr.add(i);
        }

        arr.add(0);
        arr.add(n);

        Collections.sort(arr);
        return ans(arr, 1, c, dp);
    }

    public int ans(ArrayList<Integer> arr, int i, int j, int dp[][]){

        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for(int k = i; k<=j; k++){
            int res = arr.get(j+1) - arr.get(i-1) + ans(arr, i, k-1, dp) + ans(arr, k+1, j, dp);
            mini = Math.min(mini, res);
        }

        return dp[i][j] = mini;
    }
}