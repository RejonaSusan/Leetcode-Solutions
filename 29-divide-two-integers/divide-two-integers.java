class Solution {
    public int divide(int dividend, int divisor) {
        long quotient = 0;
        long remainder = 0;

        long absdividend = Math.abs((long)dividend);
        long absdivisor = Math.abs((long)divisor);

        boolean negative = (dividend < 0) ^ (divisor < 0);

        for (int i = 31; i >= 0; i--) {
            if ((remainder + (absdivisor << i)) <= absdividend) {
                remainder += absdivisor << i;
                quotient |= 1L << i;
            }
        }

        if (negative) {
            quotient = -quotient;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        return (int)quotient;
    }
}