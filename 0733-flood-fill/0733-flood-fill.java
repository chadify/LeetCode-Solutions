class Solution {
    class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       // similar to rotten oranges.
       // if color is 1(original color) then change it to `color`.
       // traverse from original node to it's other neighbouring cells
            // level by level
        // use queue, push all the neighbours in to a queue 

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;

        int ogCol = image[sr][sc];
        q.offer(new Pair<>(sr, sc));

        while(!q.isEmpty()) {
            Pair<Integer, Integer> temp = q.poll();
            int r = temp.first;
            int c = temp.second;
            if (image[r][c] == color) {
                continue; //already visited, skip
            }
            image[r][c] = color;

            int[] row = {-1, 0, +1, 0};
            int[] col = {0, +1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == ogCol) {
                    q.offer(new Pair<>(nrow, ncol));
                }
            }
        }

        return image;
    }
}