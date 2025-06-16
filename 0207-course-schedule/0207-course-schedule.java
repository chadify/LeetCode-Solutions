import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Construct the adjacency list
        for (int[] row : prerequisites) {
            adjList.get(row[1]).add(row[0]);  // course B depends on A => edge A → B
        }

        int[] indegree = new int[numCourses];  // Fix: replaced 'V' with 'numCourses'
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adjList.get(i)) {
                indegree[neighbour]++;
            }
        }

        // Add all nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int neighbour : adjList.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        // If we were able to process all courses, return true
        return count == numCourses;
    }
}