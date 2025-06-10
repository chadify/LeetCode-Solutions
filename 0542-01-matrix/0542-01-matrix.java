import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class Pair<F, S> {
        public final F first;
        public final S second;
        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dis = new int[m][n];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();

        // initializing the visited array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair<>(new Pair<>(i, j), 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first.first;
            int col = q.peek().first.second;
            int dist = q.peek().second;
            q.poll();
            dis[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int r = row + delrow[i];
                int c = col + delcol[i];

                if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == 0) {
                    q.offer(new Pair<>(new Pair<>(r, c), dist + 1));
                    vis[r][c] = 1;
                }
            }
        }

        return dis;
    }
}
