class Solution {
    private long mod = 1000000007;
    public int countGoodNumbers(long n) {
        return (int) (pow(4, n/2) * pow(5, (n+1)/2) % mod);
    }
    private long pow(long x, long n){
        if(n == 0) return 1;
        if(n % 2 == 1){
            return x * pow(x, n-1) % mod;
        } 
        return pow(x * x % mod, n/2);
    }
}