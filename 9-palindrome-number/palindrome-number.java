class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        boolean ans = false;

        while(temp!=0){
            int digit = temp % 10;
            rev = rev*10 + digit;
            temp/=10;
        }
        if(x == rev){
            ans = true;
        }
        if(x<0){
            ans = false;
        }
        return ans;
    }
}