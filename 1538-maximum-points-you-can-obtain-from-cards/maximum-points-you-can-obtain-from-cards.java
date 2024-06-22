class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        int ans = 0;

        for(int i = n-k; i<n; i++){
            sum += cardPoints[i];
        }
        ans = sum;
        for(int i = 0; i<k ;i++){
            sum += cardPoints[i] - cardPoints[n-k+i];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
        