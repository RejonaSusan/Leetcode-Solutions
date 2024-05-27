class Solution {
    public int subarraySum(int[] a, int k) {
        int count = 0;
        int n = a.length;

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j<n ; j++){
                sum += a[j];

                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}