class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];

        // Initialize the adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<Integer>[] adjList, int[] visited) {
        visited[node] = 1;

        for (int neighbor : adjList[node]) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}