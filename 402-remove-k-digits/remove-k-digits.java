class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder s = new StringBuilder();
        Stack<Character> st = new Stack();

        if (k >= num.length()) {
            return "0";
        }

        for(int i = 0; i<num.length(); i++){
            while(!st.isEmpty() && st.peek() - '0' > num.charAt(i) - '0' && k > 0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        for (char c : st) {
            if (c == '0' && s.length() == 0)
                continue;
            s.append(c);
        }

        return s.length() == 0 ? "0" : s.toString();
    }
}