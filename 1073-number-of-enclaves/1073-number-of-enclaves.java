class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        
        // Check left and right boundaries
        for (int i = 0; i < m; i++) {
            // Left boundary (column 0)
            if (vis[i][0] != 1 && grid[i][0] == 1) {
                dfs(i, 0, grid, vis);
            }
            // Right boundary (column n-1)
            if (vis[i][n-1] != 1 && grid[i][n-1] == 1) {
                dfs(i, n-1, grid, vis);
            }
        }
        
        // Check top and bottom boundaries
        for (int j = 0; j < n; j++) {
            // Top boundary (row 0)
            if (vis[0][j] != 1 && grid[0][j] == 1) {
                dfs(0, j, grid, vis);
            }
            // Bottom boundary (row m-1)
            if (vis[m-1][j] != 1 && grid[m-1][j] == 1) {
                dfs(m-1, j, grid, vis);
            }
        }
        
        // Count unvisited land cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void dfs(int row, int col, int[][] grid, int[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = 1;
        
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int r = row + delrow[i];
            int c = col + delcol[i];
            
            if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] != 1 && grid[r][c] == 1) {
                dfs(r, c, grid, vis);  // Fixed parameter order
            }
        }
    }
}