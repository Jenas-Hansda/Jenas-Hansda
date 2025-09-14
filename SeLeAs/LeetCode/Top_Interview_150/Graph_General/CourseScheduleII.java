import java.util.*;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list representation of graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Build the graph
        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            // b --> a
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            indegree[a]++;
        }

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Add all nodes with 0 indegree
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result.add(i);
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int u = queue.poll();

            // Get neighbors of u
            if (adj.containsKey(u)) {
                for (int v : adj.get(u)) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        queue.offer(v);
                        result.add(v);
                    }
                }
            }
        }

        // Check if topological sort is possible (i.e., no cycle)
        if (result.size() != numCourses) {
            return new int[0]; // Return empty array if cycle exists
        }

        // Convert List<Integer> to int[]
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = result.get(i);
        }

        return order;
    }
}
