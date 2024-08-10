class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        for(int r[] : dp){
            Arrays.fill(r, -1);
        }

        return ans(word1, word2, n-1, m-1, dp);

    }

    public int ans(String s1, String s2, int id1, int id2, int dp[][]){
        if(id1<0){
            return id2 + 1;
        }

        if(id2 < 0){
            return id1 + 1;
        }

        if(dp[id1][id2] != -1){
            return dp[id1][id2];
        }

        if(s1.charAt(id1) == s2.charAt(id2)){
            dp[id1][id2] = ans(s1, s2, id1-1, id2-1, dp);
        }else{
            dp[id1][id2] = 1 + Math.min(ans(s1, s2, id1-1, id2-1, dp), Math.min(ans(s1, s2, id1-1, id2, dp), ans(s1, s2, id1, id2-1, dp)));
        }

        return dp[id1][id2];
    }
}