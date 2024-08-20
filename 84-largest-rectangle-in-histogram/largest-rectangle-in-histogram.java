class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int leftsmall[] = new int[n];
        int rightsmall[] = new int[n];

        Stack<Integer> st = new Stack();

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) leftsmall[i] = 0;
            else leftsmall[i] = st.peek()+1;
            
            st.push(i);
        }

        while (!st.isEmpty()) st.pop();

        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()) rightsmall[i] = n-1;
            else rightsmall[i] = st.peek()-1;

            st.push(i);
        }

        int maxi = Integer.MIN_VALUE;

        for(int i =0; i<n; i++){
            maxi = Math.max(maxi, heights[i] * (rightsmall[i] - leftsmall[i] + 1));
        }

        return maxi;
    }
}