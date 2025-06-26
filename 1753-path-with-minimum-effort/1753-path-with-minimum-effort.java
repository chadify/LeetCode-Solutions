import java.util.*;

class Solution {
    public class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));

        pq.offer(new Pair<>(0, new Pair<>(0, 0)));

        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> curr = pq.poll();
            int diff = curr.first;
            int cRow = curr.second.first;
            int cCol = curr.second.second;

            // If we reached bottom-right cell
            if (cRow == m - 1 && cCol == n - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cRow + delRow[i];
                int nCol = cCol + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
                    int nEffort = Math.max(
                        Math.abs(heights[cRow][cCol] - heights[nRow][nCol]),
                        diff
                    );

                    if (nEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = nEffort;
                        pq.offer(new Pair<>(nEffort, new Pair<>(nRow, nCol)));
                    }
                }
            }
        }

        return 0; // unreachable, but required
    }
}