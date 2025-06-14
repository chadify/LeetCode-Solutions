class Solution {
    public boolean isBipartite(int[][] graph) {

        int v = graph.length;
        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if(!dfs(i, 0, color, graph)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int neighbour: graph[node]) {
            if (color[neighbour] == -1) {
                if (!dfs(neighbour, 1 - col, color, graph)) return false;
            }
            else if (color[neighbour] == col) {
                return false;
            }
        }

        return true;
    }
}