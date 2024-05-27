class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        List<Integer> ans = new ArrayList<>();

        int top = 0, left =0, bottom = row - 1, right = col - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }
}