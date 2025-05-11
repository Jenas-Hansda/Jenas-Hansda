import java.util.*;

public class minReorder{class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        Set<String> connectionSet = new HashSet<>();

        // Build graph and connection set
        for (int[] conn : connections) {
            int start = conn[0];
            int end = conn[1];

            neighbors.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            neighbors.computeIfAbsent(end, k -> new ArrayList<>()).add(start);

            // Store original direction as a string for quick lookup
            connectionSet.add(start + "," + end);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int reverse = 0;

        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int neighbor : neighbors.getOrDefault(city, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);

                    // If the edge is not in the reverse direction, we must reverse it
                    if (!connectionSet.contains(neighbor + "," + city)) {
                        reverse++;
                    }

                    queue.add(neighbor);
                }
            }
        }

        return reverse;
    }
}
}