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
        
        while(!st.isEmpty()){
            s.append(st.pop());
        }

        s.reverse();
        while (s.length() > 0 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }

        return s.length() == 0 ? "0" : s.toString();
    }
}