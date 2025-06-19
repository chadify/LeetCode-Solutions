class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reversed = new ArrayList<>();
        int[] indeg = new int[n];

        // Initialize the reversed adjacency list
        for (int i = 0; i < n; i++) {
            reversed.add(new ArrayList<>());
        }

        // Reverse the edges
        for (int u = 0; u < n; u++) {
            // u -> v
            // v -> u
            for (int v : graph[u]) {
                reversed.get(v).add(u);  // reverse the edge u -> v to v -> u
                indeg[u]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);

            for (int neighbour: reversed.get(node)) {
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        list.sort(Integer::compareTo);  // or simply Collections.sort(numbers);

        return list;
    }
}