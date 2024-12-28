class Solution {
    private char[][] board;
    private String word;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        
        if (r < 0 || c < 0 || 
            r >= board.length || c >= board[0].length ||
            word.charAt(i) != board[r][c]) {
            return false;
        }
        
        // Save current cell and mark as visited
        char temp = board[r][c];
        board[r][c] = '#';
        
        // Try all four directions
        boolean result = dfs(r + 1, c, i + 1) ||  // down
                        dfs(r - 1, c, i + 1) ||  // up
                        dfs(r, c + 1, i + 1) ||  // right
                        dfs(r, c - 1, i + 1);    // left
        
        // Restore the cell
        board[r][c] = temp;
        
        return result;
    }
}