class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        int pos = 0;
        int sign = 1;
        long result = 0;

        if (s.length() == 0) {
            return 0; 
        }

        if (s.charAt(pos) == '-' || s.charAt(pos) == '+') {
            sign = (s.charAt(pos) == '-') ? -1 : 1;
            pos++;
        }

        while(pos < s.length() && Character.isDigit(s.charAt(pos))){
            int digit = s.charAt(pos) - '0';
            result = result * 10 + digit;
            System.out.println(result);
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            pos++;
        }

        return (int)(result * sign);
    }
}