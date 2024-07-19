class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int id = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(id)){
                    if(search(board, word, i, j, id, m, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int row, int col, int id, int m, int n){
        if(id == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(id) || board[row][col] == '!'){
            return false;
        }

        char c = board[row][col];
        board[row][col] = '!';

        boolean top = search(board, word, row-1, col, id+1, m, n);
        boolean left = search(board, word, row, col-1, id+1, m, n);
        boolean bottom = search(board, word, row+1, col, id+1, m, n);
        boolean right = search(board, word, row, col+1, id+1, m, n);

        board[row][col] = c;
        return top || right || left || bottom;
    }
}