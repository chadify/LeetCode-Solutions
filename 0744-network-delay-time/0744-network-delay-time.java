class Solution {
    class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0], v = times[i][1], w = times[i][2];
            adjList.get(u).add(new Pair<>(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.second, b.second)
        );
        pq.offer(new Pair<>(k, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> it = pq.poll();
            int curNode = it.first;
            int curTime = it.second;

            for (Pair<Integer, Integer> iter : adjList.get(curNode)) {
                int adjNode = iter.first;
                int edgeW = iter.second;

                if (curTime + edgeW < dist[adjNode]) {
                    dist[adjNode] = curTime + edgeW;
                    pq.offer(new Pair<>(adjNode, dist[adjNode]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}