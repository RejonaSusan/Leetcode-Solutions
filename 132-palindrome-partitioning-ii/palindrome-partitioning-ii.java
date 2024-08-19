class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return ans(s, 0, n, dp) - 1;
    }

    public int ans(String str, int s, int n, int dp[]) {
        if (s >= n) {
            return 0;  
        }

        if (dp[s] != -1) {
            return dp[s];
        }

        int mini = Integer.MAX_VALUE;

        for (int i = s; i < n; i++) {  // Loop should go to n-1
            if (isPalindrome(str, s, i)) {
                int res = 1 + ans(str, i + 1, n, dp);
                mini = Math.min(mini, res);
            }
        }

        return dp[s] = mini;
    }

    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
