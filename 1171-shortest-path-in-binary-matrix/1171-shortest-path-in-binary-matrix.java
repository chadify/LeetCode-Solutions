class Solution {
    public class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList<>();
        q.offer(new Pair<>(1, new Pair<>(0, 0)));

        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1}; 
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> node = q.poll();
            int curDist = node.first;
            int curRow = node.second.first;
            int curCol = node.second.second;

            if (curRow == m - 1 && curCol == n - 1) return curDist;

            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + delRow[i];
                int nextCol = curCol + delCol[i];

                if (nextRow >= 0 && nextRow < m &&
                    nextCol >= 0 && nextCol < n &&
                    grid[nextRow][nextCol] == 0 &&
                    curDist + 1 < dist[nextRow][nextCol]) {

                    dist[nextRow][nextCol] = curDist + 1;
                    q.offer(new Pair<>(curDist + 1, new Pair<>(nextRow, nextCol)));
                }
            }
        }

        return -1;
    }
}