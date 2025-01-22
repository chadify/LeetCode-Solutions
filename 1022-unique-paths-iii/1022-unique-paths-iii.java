class Solution {
    private int count = 0;

    public int uniquePathsIII(int[][] grid) {
        int[] start = findStart(grid);
        int freeSpaces = countFreeSpaces(grid);
        backtrack(start[0], start[1], freeSpaces, grid);
        return count;
    }

    private void backtrack(int i, int j, int freeSpaces, int[][] grid) {
        // Boundary check and obstacle check
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }

        // Reached the end
        if (grid[i][j] == 2) {
            // Check if all free spaces are covered
            if (freeSpaces == 0) {
                count++;
            }
            return;
        }

        // Mark the cell as visited
        int temp = grid[i][j];
        grid[i][j] = -1; // Mark as visited

        // Explore all four directions
        backtrack(i - 1, j, freeSpaces - 1, grid); // Up
        backtrack(i + 1, j, freeSpaces - 1, grid); // Down
        backtrack(i, j - 1, freeSpaces - 1, grid); // Left
        backtrack(i, j + 1, freeSpaces - 1, grid); // Right

        // Backtrack and unmark the cell
        grid[i][j] = temp;
    }

    private int[] findStart(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Shouldn't happen
    }

    private int countFreeSpaces(int[][] grid) {
        int freeSpaces = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2) {
                    freeSpaces++;
                }
            }
        }
        return freeSpaces;
    }
}