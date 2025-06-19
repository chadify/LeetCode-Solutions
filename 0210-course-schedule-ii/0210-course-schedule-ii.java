import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the graph and fill indegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course);
            indeg[course]++;
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int neighbor : adjList.get(node)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (res.size() == numCourses) {
            // Convert list to array
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = res.get(i);
            }
            return result;
        } else {
            return new int[0]; // Cycle detected, return empty array
        }
    }
}