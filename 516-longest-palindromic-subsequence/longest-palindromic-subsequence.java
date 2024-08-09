class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        return lcs(s, rev);
    }

    public int lcs(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int dp[][] = new int[n1+1][n2+1];

        for(int i = 0; i<n1; i++){
            dp[i][0] = 0;
        }

        for(int i = 0; i<n2; i++){
            dp[0][i] = 0;
        }

        for(int id1 = 1; id1<=n1; id1++){
            for(int id2 = 1; id2<=n2; id2++){
                if(s1.charAt(id1-1) == s2.charAt(id2-1)){
                    dp[id1][id2] = 1 + dp[id1-1][id2-1];
                }else{
                    dp[id1][id2] = Math.max(dp[id1-1][id2], dp[id1][id2-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}