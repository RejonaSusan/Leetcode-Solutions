class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int dp[][] = new int[n1][n2];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        return ans(text1, text2, n1-1, n2-1, dp);
    }

    public int ans(String s1, String s2, int id1, int id2, int dp[][]){

        if(id1 < 0 || id2 < 0){
            return 0;
        }

        if(dp[id1][id2] != -1){
            return dp[id1][id2];
        }

        if(s1.charAt(id1) == s2.charAt(id2)){
            return dp[id1][id2] = 1 + ans(s1, s2, id1-1, id2-1, dp);
        }else{
            return dp[id1][id2] = Math.max(ans(s1, s2, id1-1, id2, dp), ans(s1, s2, id1, id2-1, dp));
        }
    }
}