class Pair<U, V> {
    U first;
    V second;
    Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            boolean foundRotten = false;

            for (int i = 0; i < len; i++) { //multi source bfs
                Pair<Integer, Integer> it = q.poll();
                int[] delRow = {0, 1, 0, -1};
                int[] delCol = {1, 0, -1, 0};
                for (int j = 0; j < 4; j++) {
                    int curRow = it.first + delRow[j];
                    int curCol = it.second + delCol[j];
                    if (curRow >= 0 && curRow < n && curCol >= 0 && curCol < m && grid[curRow][curCol] == 1) {
                        grid[curRow][curCol] = 2;
                        q.offer(new Pair(curRow, curCol));
                        foundRotten = true;
                    }
                }
            }
            if (foundRotten) minutes++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}