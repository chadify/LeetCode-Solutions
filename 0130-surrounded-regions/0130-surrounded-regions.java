class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];

        // Traverse first and last row
        for (int j = 0; j < n; j++) {
            if (vis[0][j] != 1 && board[0][j] == 'O') {
                dfs(0, j, vis, board);
            }
            if (vis[m-1][j] != 1 && board[m-1][j] == 'O') {
                dfs(m-1, j, vis, board);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < m; i++) {
            if (vis[i][0] != 1 && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
            if (vis[i][n-1] != 1 && board[i][n-1] == 'O') {
                dfs(i, n-1, vis, board);
            }
        }

        // Flip unvisited 'O's to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] != 1 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col, int[][] vis, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = 1;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int r = row + delrow[i];
            int c = col + delcol[i];

            if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] != 1 && board[r][c] == 'O') {
                dfs(r, c, vis, board);
            }
        }
    }
}
