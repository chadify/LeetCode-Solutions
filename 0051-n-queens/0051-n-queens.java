class Solution {
    private HashSet<Integer> col = new HashSet<>();
    private HashSet<Integer> posDiag = new HashSet<>();
    private HashSet<Integer> negDiag = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
                
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, n, result);
        return result;
    }
    
    private void backtrack(char[][] board, int r, int n, List<List<String>> result) {
        if (r == n) {
            result.add(arrayToList(board));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c))
                continue;
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';
            
            backtrack(board, r+1, n, result);
            
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
    
    private List<String> arrayToList(char[][] array) {
        List<String> list = new ArrayList<>();
        for (char[] row : array) {
            list.add(new String(row));
        }
        return list;
    }
}