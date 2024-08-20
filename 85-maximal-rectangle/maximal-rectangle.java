class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxarea = 0;

        int height[] = new int[matrix[0].length];

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = ans(height);

            maxarea = Math.max(area, maxarea);
        }
        return maxarea;
    }

    public int ans(int r[]){
        int n = r.length;
        Stack<Integer> st = new Stack<>();

        int maxi = 0;

        for(int i = 0; i<=n; i++){
            while(!st.isEmpty() && (i==n || r[st.peek()]>= r[i])){
                int h = r[st.peek()];
                st.pop();

                int w;
                if(st.isEmpty()){
                    w = i;
                }else{
                    w = i - st.peek() - 1;
                }

                maxi = Math.max(maxi, w*h);
            }
            st.push(i);
        }

        return maxi;
    }
}