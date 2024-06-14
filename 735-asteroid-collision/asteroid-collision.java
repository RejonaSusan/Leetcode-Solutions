class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack();

        for(int n: asteroids){
            if(n > 0){
                st.push(n);
            }else{
                while(!st.isEmpty() && st.peek() < -n && st.peek() > 0){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0){
                    st.push(n);
                }else if(st.peek() == -n){
                    st.pop();
                }
            }
            
        }

        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}